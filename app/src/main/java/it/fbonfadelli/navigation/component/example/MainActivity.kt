package it.fbonfadelli.navigation.component.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navigationController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        setSupportActionBar(toolbar)

        navigationController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.lastExtractionFragment,
                R.id.extractionArchiveFragment,
                R.id.generateSextainFragment,
                R.id.yourSextainFragment
            ), drawerLayout
        )

        setUpDrawerLayout(navigationView)
    }

    private fun setUpDrawerLayout(navigationView: NavigationView) {
        navigationView.setupWithNavController(navigationController)
        toolbar.setupWithNavController(navigationController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean =
        (navigateUp(navigationController, appBarConfiguration) || super.onSupportNavigateUp())

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}