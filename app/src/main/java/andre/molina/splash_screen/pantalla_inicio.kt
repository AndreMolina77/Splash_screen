package andre.molina.splash_screen

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pantalla_inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1-Llamar a todos los elementos

        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val txtDUI = findViewById<EditText>(R.id.txtDUI)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        btnAgregar.setOnClickListener {
            //Validaremos que los campos no estén vacíos
            if(txtNombre.text.isEmpty() || txtContrasena.text.isEmpty()
                || txtEdad.text.isEmpty() || txtEmail.text.isEmpty()
                || txtDUI.text.isEmpty()
                ){
                Toast.makeText(this, "No todos los campos han sido llenoas", Toast.LENGTH_SHORT).show()
            }else{
                if(txtEdad.text.matches("[0-9]+".toRegex()))
                    //Si la edad del campo txtEdad no concuerda con uno
            // o más digitos, toRegex no hace la vadilación
                    //toRegex valida
                    Toast.makeText(this, "Solo números en la edad son válidos", Toast.LENGTH_SHORT).show()
            }
                //Si el texto de mi cuadrito está vacío, no solo el cuadrito
                //ejemplo txtNombre.isEmpty()
            //Verificaremos que los correos sean reales



        }


    }
}