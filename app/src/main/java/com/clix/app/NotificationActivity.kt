package com.clix.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ImageView

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.notification)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupTopMenuNavigation()
        setupFilterTabs()
        setupMarkAllRead()
        setupBottomNavigation()
    }

    private fun setupTopMenuNavigation() {
        val userPicture = findViewById<ImageView>(R.id.user_picture)
        userPicture.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }

    private fun setupFilterTabs() {
        val tabAll = findViewById<TextView>(R.id.tab_all)
        val tabBills = findViewById<TextView>(R.id.tab_bills)
        val tabOutages = findViewById<TextView>(R.id.tab_outages)
        val tabAlerts = findViewById<TextView>(R.id.tab_alerts)

        setActiveTab(tabAll, listOf(tabBills, tabOutages, tabAlerts))

        tabAll.setOnClickListener {
            setActiveTab(tabAll, listOf(tabBills, tabOutages, tabAlerts))
        }

        tabBills.setOnClickListener {
            setActiveTab(tabBills, listOf(tabAll, tabOutages, tabAlerts))
        }

        tabOutages.setOnClickListener {
            setActiveTab(tabOutages, listOf(tabAll, tabBills, tabAlerts))
        }

        tabAlerts.setOnClickListener {
            setActiveTab(tabAlerts, listOf(tabAll, tabBills, tabOutages))
        }
    }

    private fun setActiveTab(activeTab: TextView, inactiveTabs: List<TextView>) {
        activeTab.setBackgroundResource(R.drawable.rectangle_rad25dp)
        activeTab.setBackgroundColor(getColor(R.color.clix_green))
        activeTab.setTextColor(getColor(R.color.white))

        inactiveTabs.forEach { tab ->
            tab.setBackgroundResource(R.drawable.rectangle_rad25dp)
            tab.setBackgroundColor(getColor(android.R.color.background_light))
            tab.setTextColor(getColor(android.R.color.darker_gray))
        }
    }

    private fun setupMarkAllRead() {
        val markAllReadButton = findViewById<TextView>(R.id.mark_all_read)
        markAllReadButton.setOnClickListener {
            // Handle mark all as read
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
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }
    }
}