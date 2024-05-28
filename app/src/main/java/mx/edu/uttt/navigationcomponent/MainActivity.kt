package mx.edu.uttt.navigationcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import mx.edu.uttt.navigationcomponent.detalles.PantallaDetalle
import mx.edu.uttt.navigationcomponent.inicio.PantallaInicio
import mx.edu.uttt.navigationcomponent.ui.theme.NavigationComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationComponentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navController = rememberNavController()
                    //Cuando inicie la app, quiero que inicie en 'inicio' y arranque el homeScreen
                    NavHost(navController = navController, startDestination = "inicio" ){
                        composable(route = "inicio"){
                            PantallaInicio(){
                                navController.navigate("detalles/$it"){

                                }
                            }

                        }
                        composable("detalles/{body}",
                            arguments = listOf(
                                //va a recibir un argumento llamado body de tipo String
                               // navArgument("body"){
                                 //   type= NavType.StringType
                                //}
                            )){
                        val body = it.arguments?.getString("body")?: ""
                            PantallaDetalle(body)
                        }
                    }
                }
            }
        }
    }
}

