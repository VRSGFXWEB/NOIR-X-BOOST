package com.centralvex.noirxboost.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.centralvex.noirxboost.ui.theme.GlassCard
import com.centralvex.noirxboost.ui.theme.NoirBackgroundGradient
import com.centralvex.noirxboost.ui.theme.NoirCrimsonSoft
import com.centralvex.noirxboost.ui.theme.NoirGoldAccent
import com.centralvex.noirxboost.ui.theme.NoirTextMuted
import com.centralvex.noirxboost.ui.theme.NoirTextPrimary

// Satu-satunya kanal kontak: nomor WA pribadi + saluran WA. Tidak ada Telegram.
private const val WA_NUMBER = "6285726893424"
private const val WA_CHANNEL_URL = "https://whatsapp.com/channel/0029Vb7AtEHL2AU0IXm9642x"

@Composable
fun ContactScreen() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NoirBackgroundGradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Kontak",
                color = NoirTextPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier.padding(top = 12.dp)
            )
            Text(
                text = "by CENTRALVEX",
                color = NoirGoldAccent,
                fontSize = 13.sp
            )

            GlassCard(modifier = Modifier.fillMaxWidth()) {
                Text("WhatsApp", color = NoirTextPrimary, fontWeight = FontWeight.SemiBold)
                Text("+$WA_NUMBER", color = NoirTextMuted, modifier = Modifier.padding(top = 4.dp, bottom = 12.dp))
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/$WA_NUMBER"))
                        context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = NoirCrimsonSoft, contentColor = NoirTextPrimary)
                ) {
                    Text("Chat via WhatsApp")
                }
            }

            GlassCard(modifier = Modifier.fillMaxWidth()) {
                Text("Saluran WhatsApp", color = NoirTextPrimary, fontWeight = FontWeight.SemiBold)
                Text("Update & info terbaru", color = NoirTextMuted, modifier = Modifier.padding(top = 4.dp, bottom = 12.dp))
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(WA_CHANNEL_URL))
                        context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = NoirCrimsonSoft, contentColor = NoirTextPrimary)
                ) {
                    Text("Buka Saluran")
                }
            }
        }
    }
}
