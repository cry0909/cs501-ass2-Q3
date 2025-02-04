package com.example.musicplayerui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {  // Updated to MaterialTheme instead of MusicPlayerTheme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF121212) // Dark theme background
                ) {
                    StaticMusicPlayerUI()
                }
            }
        }
    }
}

@Composable
fun StaticMusicPlayerUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Album Cover
        Box(
            modifier = Modifier
                .size(250.dp)
                .background(Color.DarkGray),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.album_cover), // Replace with actual image
                contentDescription = "Album Cover",
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Song Title and Artist
        Text(
            text = "Easy On Me",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Adele",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Music Controls
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            MusicControlButton(R.drawable.ic_pause, "Pause")
            Spacer(modifier = Modifier.width(24.dp))
            MusicControlButton(R.drawable.ic_play, "Play")
            Spacer(modifier = Modifier.width(24.dp))
            MusicControlButton(R.drawable.ic_skip_next, "Next")
        }

    }
}

@Composable
fun MusicControlButton(imageRes: Int, contentDescription: String) {
    IconButton(
        onClick = { /* No action, static UI */ },
        modifier = Modifier
            .size(64.dp)
            .background(Color.DarkGray, shape = CircleShape)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(48.dp) // Adjust size to fit within button
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMusicPlayer() {
    MaterialTheme {
        StaticMusicPlayerUI()
    }
}