package andre.molina.splash_screen

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Aquì en mi Splash Acreen prorgramo para que vaya a la pantalla de inicio  o bienvenida
        GlobalScope.launch(Dispatchers.Main) {
            delay(3000)

            //Cambio mi pantalla
            val pantallaSiguiente = Intent(this@MainActivity, pantalla_inicio::class.java)
            startActivity(pantallaSiguiente)
            //Cuando estamos en un dipatcher o hilo tenemos que específicar que estamos en main activity, pues, a pesar que ya estemos ahí, así es en el hilo
            //Finalizamos la activity
            finish()
        }


    }
}