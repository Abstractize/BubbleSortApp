package com.example.gabab.bubblesortapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gabab.bubblesortapp.ADT.SingleList;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button generate;
    Button bubble_sort;

    TextView listString;
    TextView listStatus;

    int recursion;//Veces que revisó la lista
    int swaps;//Veces que hizo intercambios
    int compares;//Veces que comparó
    SingleList list;
    boolean sorted=false;

    public void generateList(){
        this.list = new SingleList();
        }

    public void arrangeList(){
        if (list != null && !sorted){   //Si hay lista
			int large = list.getLength()-1;//Largo de la lista - 1(Para evaluar el elemento y el siguiente)
				sorted = true;
				for (int index = 0; index < large; index++) {//Loop para cada elemento y su sucesor
				    compares++;
                    int compare1 = list.getValue(index);
				    int compare2 = list.getValue(index+1);
					if (compare1 > compare2){
					    swaps++;
					    sorted = false;
					    System.out.println("Changed: " + index +" for "+ (index+1));
						list.setValue(compare2,index);
	                    list.setValue(compare1,index+1);
	                    list.Print();
					}
				}
				large--;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listString = findViewById(R.id.textView);
        listStatus = findViewById(R.id.textView2);
        generate = findViewById(R.id.button);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recursion=0;
                swaps=0;
                compares=0;
                sorted=false;
                generateList();
                listString.setText(list.Print());
                listStatus.setText("Not Sorted");
            }
        });

        bubble_sort = findViewById(R.id.button2);
        bubble_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrangeList();
                listString.setText(list.Print());
                if (!sorted){
                    recursion++;
                }else{
                    listStatus.setText("Sorted, times arranging the list "+recursion+".Compares done:"+compares+".Swaps done:"+swaps);
                }
            }
        });
    }
}
