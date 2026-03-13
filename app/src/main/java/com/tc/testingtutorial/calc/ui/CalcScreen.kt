package com.tc.testingtutorial.calc.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp

@Composable
fun CalcScreen(viewmodel: CalcViewmodel) {
    var a by rememberSaveable { mutableStateOf("") }

    var b by rememberSaveable { mutableStateOf("") }

    var result by rememberSaveable { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {

        InField(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("FIELD_A"),
            label = "Field A",
            value = a,
            onValueChange = { a = it.toString() })

        Spacer(Modifier.height(24.dp))

        InField(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("FIELD_B"),
            label = "Field A",
            value = b,
            onValueChange = { b = it.toString() })

        Spacer(Modifier.height(24.dp))

        Text(result.toString(), modifier = Modifier.semantics {
            contentDescription = "Text for Addition result"
            testTag = "RESULT_TAG"
        })

        Button(
            {
                result = viewmodel.add(a.toInt(), b.toInt())
            },
            modifier = Modifier.testTag("add_Btn")
        ) {
            Text("Add the fields")
        }

    }
}

@Composable
fun InField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (Int) -> Unit
) {

    TextField(
        value,
        onValueChange = {
            if (it.isNotBlank()) {
                onValueChange(it.toInt())
            }
        },
        label = {
            Text(label)
        },
        placeholder = {
            Text(label)
        },
        modifier = modifier.padding(horizontal = 12.dp)
    )

}