package com.clix.app

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        enableEdgeToEdge()

        // Make status bar transparent and show notification shade
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Start with login screen
        setContentView(R.layout.login)

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Remove top padding to eliminate top border
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up sign in button click listener
        setupSignInButton()
    }

    private fun setupSignInButton() {
        val signInButton = findViewById<MaterialButton>(R.id.btn_login)
        signInButton.setOnClickListener {
            navigateToDashboard()
        }
    }

    private fun navigateToDashboard() {
        // Switch to dashboard layout
        setContentView(R.layout.dashboard)

        // Reapply window insets for the new layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }
    }
}