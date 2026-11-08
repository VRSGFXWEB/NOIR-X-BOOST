package com.centralvex.noirxboost.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.centralvex.noirxboost.ui.theme.GlassCard
import com.centralvex.noirxboost.ui.theme.NoirBackgroundGradient
import com.centralvex.noirxboost.ui.theme.NoirCrimsonSoft
import com.centralvex.noirxboost.ui.theme.NoirGoldAccent
import com.centralvex.noirxboost.ui.theme.NoirTextMuted
import com.centralvex.noirxboost.ui.theme.NoirTextPrimary
import com.centralvex.noirxboost.core.BoostRunner

data class BoostFeature(
    val title: String,
    val desc: String,
    val icon: ImageVector
)

// Semua fitur terbuka penuh — tidak ada status "locked" atau "premium" sama sekali.
private val features = listOf(
    BoostFeature("Game Mode", "Prioritaskan CPU & kill proses background", Icons.Filled.Bolt),
    BoostFeature("Touch Response", "Kurangi input lag saat main", Icons.Filled.Speed),
    BoostFeature("RAM Cleaner", "Bebaskan memori terpakai", Icons.Filled.Memory),
    BoostFeature("Thermal Control", "Jaga suhu tetap stabil", Icons.Filled.Thermostat),
)

@Composable
fun HomeScreen(onOpenContact: () -> Unit) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NoirBackgroundGradient)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { Spacer24() }

            item {
                Column {
                    Text(
                        text = "NOIR x BOOST",
                        color = NoirTextPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "Semua fitur aktif penuh — by CENTRALVEX",
                        color = NoirGoldAccent,
                        fontSize = 13.sp
                    )
                }
            }

            item {
                GlassCard(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("Status Device", color = NoirTextMuted, fontSize = 12.sp)
                            Text("Siap di-boost", color = NoirTextPrimary, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                        }
                        BoostButton(onClick = { BoostRunner.runFullBoost(context) })
                    }
                }
            }

            item {
                Text(
                    text = "Fitur",
                    color = NoirTextPrimary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            items(features) { feature ->
                GlassCard(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(feature.icon, contentDescription = feature.title, tint = NoirCrimsonSoft)
                        Column(modifier = Modifier.padding(start = 14.dp)) {
                            Text(feature.title, color = NoirTextPrimary, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                            Text(feature.desc, color = NoirTextMuted, fontSize = 12.sp)
                        }
                    }
                }
            }

            item {
                GlassCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                ) {
                    Text("Butuh bantuan?", color = NoirTextPrimary, fontWeight = FontWeight.SemiBold)
                    Text(
                        "Hubungi kami langsung lewat WhatsApp.",
                        color = NoirTextMuted,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 4.dp, bottom = 10.dp)
                    )
                    ContactLink(text = "Buka Kontak & Saluran WA", onClick = onOpenContact)
                }
            }
        }
    }
}

@Composable
private fun Spacer24() {
    Box(modifier = Modifier.padding(top = 8.dp))
}

@Composable
private fun BoostButton(onClick: () -> Unit) {
    androidx.compose.material3.Button(
        onClick = onClick,
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = NoirCrimsonSoft,
            contentColor = NoirTextPrimary
        )
    ) {
        Text("Boost Now")
    }
}

@Composable
private fun ContactLink(text: String, onClick: () -> Unit) {
    androidx.compose.material3.OutlinedButton(onClick = onClick) {
        Text(text, color = NoirGoldAccent)
    }
}
