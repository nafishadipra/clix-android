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

class BillActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.bill)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupTopMenuNavigation()
        setupRechargeButtons()
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

    private fun setupRechargeButtons() {
        val quickRechargeAllBtn = findViewById<TextView>(R.id.quick_recharge_all_btn)
        quickRechargeAllBtn.setOnClickListener {
            // Handle recharge all functionality
        }

        val rechargeElectricityBtn = findViewById<TextView>(R.id.recharge_electricity_btn)
        rechargeElectricityBtn.setOnClickListener {
            // Handle electricity recharge
        }

        val rechargeGasBtn = findViewById<TextView>(R.id.recharge_gas_btn)
        rechargeGasBtn.setOnClickListener {
            // Handle gas recharge
        }

        val rechargeWaterBtn = findViewById<TextView>(R.id.recharge_water_btn)
        rechargeWaterBtn.setOnClickListener {
            // Handle water recharge
        }

        val receiptElectricityBtn = findViewById<TextView>(R.id.receipt_electricity_btn)
        receiptElectricityBtn.setOnClickListener {
            // Handle receipt view
        }

        val receiptGasBtn = findViewById<TextView>(R.id.receipt_gas_btn)
        receiptGasBtn.setOnClickListener {
            // Handle receipt view
        }

        val receiptWaterBtn = findViewById<TextView>(R.id.receipt_water_btn)
        receiptWaterBtn.setOnClickListener {
            // Handle receipt view
        }
    }

    private fun setupBottomNavigation() {
        val rechargeButton = findViewById<LinearLayout>(R.id.nav_recharge)
        rechargeButton.setOnClickListener {
            // Already on recharge screen
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
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }
    }
}