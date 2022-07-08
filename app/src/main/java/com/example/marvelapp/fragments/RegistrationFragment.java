package com.example.marvelapp.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marvelapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class RegistrationFragment extends Fragment {

    EditText etPassword, etLogin;
    Button btnLogin, btnGoogle, btnFacebook, btnReg;
    FirebaseAuth auth;
    FirebaseDatabase bd;
    DatabaseReference users;
    ConstraintLayout constraintLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        final FragmentActivity fragmentActivity = getActivity();
        if (fragmentActivity != null) {
            fragmentActivity.findViewById(R.id.bottom_navigation).setVisibility(View.GONE);
        }

        //initialization
        etPassword = view.findViewById(R.id.et_password);
        etLogin = view.findViewById(R.id.et_login);
        btnLogin = view.findViewById(R.id.btn_login);
        btnFacebook = view.findViewById(R.id.btn_facebook);
        btnGoogle = view.findViewById(R.id.btn_google);
        btnReg = view.findViewById(R.id.btn_registration);

        constraintLayout = view.findViewById(R.id.constraint_register);
        etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

        //registration
        auth = FirebaseAuth.getInstance();
        bd = FirebaseDatabase.getInstance();
        users = bd.getReference("Users");

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerWindow();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInDialog();
            }
        });

        return view;
    }

    private void logInDialog() {
        if (TextUtils.isEmpty(etLogin.getText().toString())) {
            etLogin.setError("Пользователь не найден");
            return;
        }
        if (etPassword.getText().toString().length() < 6) {
            etPassword.setError("Неверный пароль");
        }
        auth.signInWithEmailAndPassword(etLogin.getText().toString(), etPassword.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Вы ввели неверно имя пользователся или пароль", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void registerWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setTitle("Registration");

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View registrationDialog = inflater.inflate(R.layout.registration_dialog, null);
        dialog.setView(registrationDialog);

        final EditText etUserName = registrationDialog.findViewById(R.id.et_user_name);
        final EditText etNewPassword = registrationDialog.findViewById(R.id.et_new_password);
        final EditText etEmail = registrationDialog.findViewById(R.id.et_email);

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (TextUtils.isEmpty(etEmail.getText().toString())) {
                    etEmail.setError("Вы неверно ввели адрес электронной почты");
                    return;
                }
                if (TextUtils.isEmpty(etUserName.getText().toString())) {
                    etUserName.setError("Вы не ввели Имя пользователя");
                    return;
                }
                if (etNewPassword.getText().toString().length() < 6) {
                    Toast.makeText(getContext(), "Input Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(etEmail.getText().toString(), etNewPassword.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                ArrayList<String> user = new ArrayList<>(2);
                                user.add(0, etEmail.getText().toString());
                                user.add(1, etNewPassword.getText().toString());
                                user.add(2, etUserName.getText().toString());

                                users.child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).setValue(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Toast.makeText(getContext(), "Successfully Register", Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getContext(), "Failure Register", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
            }
        });
        dialog.show();
    }
}