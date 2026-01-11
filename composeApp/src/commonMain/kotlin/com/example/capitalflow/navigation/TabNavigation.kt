package com.example.capitalflow.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capitalflow.screen.earning.EarningScreen
import com.example.capitalflow.screen.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeTab

@Serializable
object EarningsTab

sealed class TabItem(
    val route: Any,
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    data object Home : TabItem(HomeTab, "Главная", Icons.Default.Home)
    data object Earnings : TabItem(EarningsTab, "Заработок", Icons.Default.Menu)
}

@Composable
fun TabNavigation() {
    var selectedTab by remember { mutableStateOf<TabItem>(TabItem.Home) }

    // Отдельные NavController для каждого таба
    val homeNavController = rememberNavController()
    val earningsNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                TabItem.Home.let { tab ->
                    NavigationBarItem(
                        icon = { Icon(tab.icon, contentDescription = tab.title) },
                        label = { Text(tab.title) },
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab }
                    )
                }
                TabItem.Earnings.let { tab ->
                    NavigationBarItem(
                        icon = { Icon(tab.icon, contentDescription = tab.title) },
                        label = { Text(tab.title) },
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedTab) {
                is TabItem.Home -> {
                    NavHost(
                        navController = homeNavController,
                        startDestination = HomeTab,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        composable<HomeTab> {
                            HomeScreen()
                        }
                    }
                }
                is TabItem.Earnings -> {
                    NavHost(
                        navController = earningsNavController,
                        startDestination = EarningsTab,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        composable<EarningsTab> {
                            EarningScreen()
                        }
                    }
                }
            }
        }
    }
}
