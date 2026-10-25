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

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupTopMenuNavigation()
        setupPeriodSelector()
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

    private fun setupPeriodSelector() {
        val btnDay = findViewById<TextView>(R.id.btn_day)
        val btnMonth = findViewById<TextView>(R.id.btn_month)
        val btnYear = findViewById<TextView>(R.id.btn_year)

        btnDay.setOnClickListener {
            // Handle day selection
        }

        btnMonth.setOnClickListener {
            // Handle month selection
        }

        btnYear.setOnClickListener {
            // Handle year selection
        }
    }

    private fun setupBottomNavigation() {
        val rechargeButton = findViewById<LinearLayout>(R.id.nav_recharge)
        rechargeButton.setOnClickListener {
            val intent = Intent(this, BillActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        val meterButton = findViewById<LinearLayout>(R.id.nav_meter)
        meterButton.setOnClickListener {
            val intent = Intent(this, MeterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        val homeButton = findViewById<LinearLayout>(R.id.nav_home)
        homeButton.setOnClickListener {
            // Already on home
        }

        val mapButton = findViewById<LinearLayout>(R.id.nav_map)
        mapButton.setOnClickListener {
            val intent = Intent(this, OutageActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        val settingsButton = findViewById<LinearLayout>(R.id.nav_settings)
        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}