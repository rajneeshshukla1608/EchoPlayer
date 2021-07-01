package com.rajneesh.echoplayer.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
//import android.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.rajneesh.echoplayer.*
import com.rajneesh.echoplayer.fragment.Aboutus
import com.rajneesh.echoplayer.fragment.Allsongs
import com.rajneesh.echoplayer.fragment.Favourites
import com.rajneesh.echoplayer.fragment.Settings

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView

    var previousMenuItem:MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.Toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)
        setUpToolbar()

        openAllsongs()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            if(previousMenuItem != null){
                previousMenuItem?.isChecked = false
            }

            it.isChecked = true
            it.isChecked = true
            previousMenuItem = it

            when(it.itemId){
                R.id.allSongs -> {

                    openAllsongs()
                    drawerLayout.closeDrawers()
                }
                R.id.favourites ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, Favourites())

                        .commit()
                    supportActionBar?.title ="Favourites"

                    drawerLayout.closeDrawers()
                }
                R.id.setting ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, Settings())

                        .commit()
                    supportActionBar?.title ="Settings"

                    drawerLayout.closeDrawers()

                }
                R.id.aboutus -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, Aboutus())

                        .commit()
                    supportActionBar?.title ="About us"

                    drawerLayout.closeDrawers()

                }
            }
            return@setNavigationItemSelectedListener true
        }

    }

    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "All songs"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
    fun openAllsongs(){
        val fragment = Allsongs()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, Allsongs())
            .commit()
        supportActionBar?.title = "All songs"
        navigationView.setCheckedItem(R.id.allSongs)
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)

        when(frag){
            !is Allsongs -> openAllsongs()

            else -> super.onBackPressed()
        }
    }

}