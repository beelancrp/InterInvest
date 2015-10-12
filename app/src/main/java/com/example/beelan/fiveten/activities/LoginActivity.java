package com.example.beelan.fiveten.activities;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.beelan.fiveten.R;
import com.example.beelan.fiveten.supports.User;
import com.example.beelan.fiveten.supports.UserLocalStore;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private EditText _emailText;
    private EditText _passwordText;
    private Button _loginButton;
    private TextInputLayout _emailTextInput;
    private TextInputLayout _passwordTextInput;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _emailText         = (EditText)         findViewById(R.id.input_email);
        _passwordText      = (EditText)         findViewById(R.id.input_password);
        _loginButton       = (Button)           findViewById(R.id.btn_login);
        _emailTextInput    = (TextInputLayout)  findViewById(R.id.TI_email);
        _passwordTextInput = (TextInputLayout)  findViewById(R.id.TI_pass);

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog_M);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        final String email    = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess(email, password);
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 1500);
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess(String login, String pass) {
        _loginButton.setEnabled(true);
        UserLocalStore.setUserData(new User(login, pass));
        UserLocalStore.setUserLoggedIn(true);
        setResult(RESULT_OK);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailTextInput.setError("enter a valid email address");
            _emailTextInput.setErrorEnabled(true);
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordTextInput.setError("between 4 and 10 alphanumeric characters");
            _passwordTextInput.setErrorEnabled(true);
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}
