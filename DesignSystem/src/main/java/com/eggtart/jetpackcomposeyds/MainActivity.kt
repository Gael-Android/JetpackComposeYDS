package com.eggtart.jetpackcomposeyds

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
//import com.eggtart.jetpackcomposeyds.ui.theme.atom.CheckBox
//import com.eggtart.jetpackcomposeyds.ui.theme.atom.CheckBoxState

data class PersonData(
    var name: String,
    var id: Int,
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeYDSTheme {

            }
        }
    }
}

@Composable
fun TestComp() {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        Toast.makeText(
            context,
            "TestComp activate",
            Toast.LENGTH_SHORT
        ).show()
    }

    var personData by rememberSaveable {
        mutableStateOf(
            0
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
//        Text("${personData.name} ${personData.id}")
        Text("$personData")

        Button(
            onClick = {
                personData++
            },
        ) {
            Text("버튼")
        }
    }
}

@Preview(
    showSystemUi = true,
)
@Composable
fun Preview() {
    JetpackComposeYDSTheme {
        Column {
            TestComp()
        }
    }
}

