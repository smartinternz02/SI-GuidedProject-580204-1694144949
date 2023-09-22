import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomInputField(
    label: String,
    fieldValue: TextFieldValue,
    onFieldValChange: (TextFieldValue) -> Unit,
) {
    OutlinedTextField(
        label = { Text(text = label) },
        value = fieldValue,
        onValueChange = onFieldValChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default,
        visualTransformation = PasswordVisualTransformation()
    )

}