package com.tochukwu.deliveryrooopractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.tochukwu.deliveryrooopractice.databinding.ActivityMainBinding
import com.tochukwu.deliveryrooopractice.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply{
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

            bottomNavigationView.apply{
                background = null;
                setupWithNavController(navHostFragment.findNavController())
            }
        }
    }


}




/**
private lateinit var binding: ActivityMainBinding

override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
binding = ActivityMainBinding.inflate(layoutInflater)
setContentView(binding.root)


binding.apply {
val navHostFragment =
supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

bottomNavigationView.apply {
background = null
menu.getItem(2).isEnabled = false
setupWithNavController(navHostFragment.findNavController())
setOnNavigationItemReselectedListener { Unit }
}

fabNewPost.setOnClickListener {
navHostFragment.findNavController().navigate(
R.id.globalActionToCreatePostFragment
)
}
}
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {
when(item.itemId){
R.id.miLogout -> {
FirebaseAuth.getInstance().signOut()
Intent(this, AuthActivity::class.java).also {
startActivity(it)
}
finish()
}
}
return super.onOptionsItemSelected(item)
}

override fun onCreateOptionsMenu(menu: Menu?): Boolean {
menuInflater.inflate(R.menu.main_menu, menu)
return super.onCreateOptionsMenu(menu)
}


}
**/