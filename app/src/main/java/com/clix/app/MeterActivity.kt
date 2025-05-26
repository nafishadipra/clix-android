package com.clix.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.TextView

class MeterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.meter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupTopMenuNavigation()
        setupMeterActions()
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
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }

    private fun setupMeterActions() {
        val electricityActions = findViewById<LinearLayout>(R.id.electricity_actions)
        val gasActions = findViewById<LinearLayout>(R.id.gas_actions)
        val waterActions = findViewById<LinearLayout>(R.id.water_actions)

        // Setup click listeners for meter action buttons
        electricityActions.setOnClickListener {
            // Handle electricity meter actions
        }

        gasActions.setOnClickListener {
            // Handle gas meter actions
        }

        waterActions.setOnClickListener {
            // Handle water meter actions
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
            // Already on meter screen
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
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }
    }
}