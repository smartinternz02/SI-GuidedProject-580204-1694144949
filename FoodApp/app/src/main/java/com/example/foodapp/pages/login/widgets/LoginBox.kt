import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.R


@Composable
fun LoginBox(){
    Box(modifier = Modifier.graphicsLayer(rotationZ = -12f)) {
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFFBF360C),
                    shape = RoundedCornerShape(20.dp)
                )
                .height(110.dp)
                .width(340.dp)
                .graphicsLayer(rotationZ = -2f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "LOGIN",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.anton_regular)),
                    fontSize = 50.sp
                )
            )
        }
    }
}