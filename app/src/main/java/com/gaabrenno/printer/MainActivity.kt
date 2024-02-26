import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.gaabrenno.printer.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val printButton: Button = findViewById(R.id.printButton)
        printButton.setOnClickListener {
            printHelloWorld()
        }
    }

    @android.support.annotation.RequiresApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    private fun printHelloWorld() {
        Thread {
            try {
                val printer = EscPosPrinter(TcpConnection("192.168.1.150", 9300, 15), 203, 48f, 32)
                printer.printText("Hello World!!! By Gaabrenno")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }
}

