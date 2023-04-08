package com.example.dz030423;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float thing1=70;//цена пальто
    byte skidka1=77;//скидка на пальто
    float thing2=25;//цена шляпа
    byte skidka2=37;//скидка на шляпу
    float thing3=53;//цена костюм
    byte skidka3=44;//скидка на костюм
    float thing4=19;//цена сорочка
    byte skidka4=0;//скидка на сорочка
    float thing5=41;//цена туфли
    byte skidka5=32;//скидка на туфли
    float summa=3;

    private float price(){//подсчет стоимости гардероба
        float count=(thing1-thing1*skidka1/100)+(thing2-thing2*skidka2/100)+
                (thing3-thing3*skidka3/100)+(thing4-thing4*skidka4/100)+
                (thing5-thing5*skidka5/100);
        return count;
    }
    private boolean possibility() {//определение достаточности суммы денег
        if (price() <= summa) {
            return true;
        } else {
            return false;
        }
    }

    private float balance() {/*если суммы достаточно, то выводится сумма сдачи,
    если нет то выводится -1*/
        if (possibility()) {
            return summa-price();
        } else {
            return -1;
        }
    }
        private TextView possibilityOut;/* объявление переменных для вывода на экран
        Тип переменных TextView используется
        для вывода на экран*/
    private TextView balanceOut;/* объявление переменных для вывода на экран
        Тип переменных TextView используется
        для вывода на экран*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/* метод привязывается к разметке
        activity_main*/
        possibilityOut=findViewById(R.id.textView5);/* привязка переменной possibilityOut
        типа TextView к окну textView5 */
        balanceOut=findViewById(R.id.textView7);/* привязка переменной possibilityOut
        типа TextView к окну textView7 */

        if (possibility()) {/* если possibility()=true, то выполняются следующие действия*/
            possibilityOut.setText("Средств достаточно");/* с помощью метода setText в
            переменную possibilityOut вводится текст в скобках. А переменная possibilityOut
            привязана к окну textView5*/
            balanceOut.setText("остаток от покупки: "+balance()+" монет");
        }
    else {// иначе выполняются следующие действия
            possibilityOut.setText("Средств не хватает");
            balanceOut.setText("Сдачи нет, т.к. не хватает средств");
         }
    }
}