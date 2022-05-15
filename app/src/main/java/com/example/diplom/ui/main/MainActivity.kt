package com.example.diplom.ui.main

import android.os.Bundle
import android.content.Context
import android.content.Intent
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.diplom.R
import com.example.diplom.databinding.MainActivityBinding
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseActivity

class MainActivity : BaseActivity(), NavController.OnDestinationChangedListener {

    companion object {
        fun createStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    private val binding by viewBinding(MainActivityBinding::inflate)


    private val viewModel: MainActivityViewModel by lazy {
        viewModelFactory.create(
            MainActivityViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.bottomNavigationView.setupWithNavController(
            getNavController().apply {
                addOnDestinationChangedListener(this@MainActivity)
            }
        )

        binding.bottomNavigationView.setOnNavigationItemReselectedListener {
            getNavController().apply {
                popBackStack(it.itemId, true)
                navigate(it.itemId)
            }
        }
    }


    override fun onBindViewModel() = Unit

    private fun getNavController(): NavController {
        return (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment).navController
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) = binding.bottomNavigationView.updatePadding(bottom = 0)

    fun handleBottomNavigationVisibility(showBottomNavigationView: Boolean) {
        binding.bottomNavigationView.isVisible = showBottomNavigationView
    }
}
