package com.meshmind.clix

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Switch

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.settings)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupTopMenuNavigation()
        setupProfileSection()
        setupSettingsOptions()
        setupBottomNavigation()
    }

    private fun setupTopMenuNavigation() {
        val notificationIcon = findViewById<ImageView>(R.id.notification_icon)
        notificationIcon.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        val userPicture = findViewById<ImageView>(R.id.user_picture)
        userPicture.setOnClickListener {
            // Already on settings
        }
    }

    private fun setupProfileSection() {
        val editProfileBtn = findViewById<TextView>(R.id.edit_profile_btn)
        editProfileBtn.setOnClickListener {
            // Handle edit profile
        }
    }

    private fun setupSettingsOptions() {
        // Account Settings
        val personalInfoItem = findViewById<LinearLayout>(R.id.personal_info_item)
        personalInfoItem.setOnClickListener {
            // Handle personal information
        }

        val securityItem = findViewById<LinearLayout>(R.id.security_item)
        securityItem.setOnClickListener {
            // Handle security settings
        }

        val paymentMethodsItem = findViewById<LinearLayout>(R.id.payment_methods_item)
        paymentMethodsItem.setOnClickListener {
            // Handle payment methods
        }

        // Notification Settings
        val pushNotificationsSwitch = findViewById<Switch>(R.id.push_notifications_switch)
        pushNotificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle push notifications toggle
        }

        val emailNotificationsSwitch = findViewById<Switch>(R.id.email_notifications_switch)
        emailNotificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle email notifications toggle
        }

        val smsNotificationsSwitch = findViewById<Switch>(R.id.sms_notifications_switch)
        smsNotificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle SMS notifications toggle
        }

        // App Preferences
        val darkModeSwitch = findViewById<Switch>(R.id.dark_mode_switch)
        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle dark mode toggle
        }

        val languageItem = findViewById<LinearLayout>(R.id.language_item)
        languageItem.setOnClickListener {
            // Handle language selection
        }

        val helpSupportItem = findViewById<LinearLayout>(R.id.help_support_item)
        helpSupportItem.setOnClickListener {
            // Handle help and support
        }

        // Logout
        val logoutItem = findViewById<LinearLayout>(R.id.logout_item)
        logoutItem.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun setupBottomNavigation() {
        val rechargeButton = findViewById<LinearLayout>(R.id.nav_recharge)
        rechargeButton.setOnClickListener {
            val intent = Intent(this, BillActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }

        val meterButton = findViewById<LinearLayout>(R.id.nav_meter)
        meterButton.setOnClickListener {
            val intent = Intent(this, MeterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }

        val homeButton = findViewById<LinearLayout>(R.id.nav_home)
        homeButton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }

        val mapButton = findViewById<LinearLayout>(R.id.nav_map)
        mapButton.setOnClickListener {
            val intent = Intent(this, OutageActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }

        val settingsButton = findViewById<LinearLayout>(R.id.nav_settings)
        settingsButton.setOnClickListener {
            // Already on settings screen
        }
    }
}