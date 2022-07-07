package co.tiagoaguiar.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Criar os objetos vivos e ter as referencia deles
        val editText: EditText = findViewById(R.id.editNumber)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        btnGenerate.setOnClickListener {
            // Aqui é onde colocamos a lógica de programação. Ele dispara após o evento
            // de touch do usuário no botão.

            // Armazenar o dado que estiver dentro do campo EditText
            val text = editText.text.toString()

            // executa a função para gerar os números após clicar no botão
            numberGenerator(text, txtResult)
        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        // Validação se caso o campo estiver vazio

        if (text.isEmpty()) {
            // O Toast, nada mais é do que uma mensagem de alerta.
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

        // Validação se caso colocar um número menor que 6 ou maior que 15
        val number = text.toInt() // converter para inteiro

        if (number < 6 || number > 15) {
            // O Toast, nada mais é do que uma mensagem de alerta.
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

        val numbers = mutableSetOf<Int>() // sendo SetOf - não poderá ter números repetidos.
        val random = Random() // uma variável que gera um número aleatório

        while(true) {
            val numb = random.nextInt(60) // vai gerar os números de 0 a 59
            numbers.add(numb + 1) // adicionar à nossa lista, o número que gerou mais 1

            //Se a quantidade de números dentro da lista, for igual à quantidade passada. Saia do loop
            if (numbers.size == number) {
                break
            }
        }
        // utilizar o método sorted() para ordenar os números do menor para o maior
        val sortedNumbers = numbers.sorted()

        // armazenar os dados no txtResult e transformar em uma string, adicionando um separador " - "
        txtResult.text = sortedNumbers.joinToString(" - ")

    }
}