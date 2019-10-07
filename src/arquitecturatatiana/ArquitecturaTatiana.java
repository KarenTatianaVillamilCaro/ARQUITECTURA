//REGISTRADORA BUS INTERMUNICIPAL

const int Trigger = 12;   //Pin digital 2 para el Trigger del sensor
const int Echo =9;//Pin digital 3 para el Echo del sensor
const  int  LED=4;
unsigned long tiempo;
void setup() {
  Serial.begin(9600);//iniciailzamos la comunicación
  pinMode(Trigger, OUTPUT); //pin como salida
  pinMode(Echo, INPUT);  //pin como entrada
  digitalWrite(Trigger, LOW);//Inicializamos el pin con 0
  int i = 0 ;
        for ( i = 6 ; i < 14 ; i++)
              pinMode( i , OUTPUT) ;
        tiempo=millis();   
}

void loop()
{
   long t; //timepo que demora en llegar el eco
  long d; //distancia en centimetros
int pe=0,pago; 
  for(int ti=0;ti<40;ti++){
 //if ((tiempo==0xffffffff) || (millis()-tiempo > 30*1000))
    //           {
      //          tiempo=0xffffffff;
        //        return;
          //     }

  digitalWrite(Trigger, HIGH);
  delayMicroseconds(10);          //Enviamos un pulso de 10us
  digitalWrite(Trigger, LOW);
  
  t = pulseIn(Echo, HIGH); //obtenemos el ancho del pulso
  d = t/59;             //escalamos el tiempo a una distancia en cm
  if (d<50)
  {
     digitalWrite(LED, LOW);
     delay(1000);
     pe=pe+1;
     pago = pe *1500;

 delay(500);          
  }

Serial.print("\n valor a cobrar :\n ");
Serial.print(pago);  
}
}


//SENSOR INTRUSOS, SONAR Y ENCENDER LUZ

const int pinBuzzer = 2 ;
const int Trigger = 12;   //Pin digital 2 para el Trigger del sensor
const int Echo =9;//Pin digital 3 para el Echo del 
const  int  LED=4;
 
void setup() 
{
  
   Serial.begin(9600);//iniciailzamos la comunicación
   pinMode(Trigger, OUTPUT); //pin como salida
  pinMode(Echo, INPUT);  //pin como entrada
  digitalWrite(Trigger, LOW);//Inicializamos e l pin con 0
    pinMode(LED, OUTPUT);
  
}
 
void loop() 
{ long t; //timepo que demora en llegar el eco
  long d; //distancia en centimetros

  digitalWrite(Trigger, HIGH);
  delayMicroseconds(10);          //Enviamos un pulso de 10us
  digitalWrite(Trigger, LOW);
  
  t = pulseIn(Echo, HIGH); //obtenemos el ancho del pulso
  d = t/59;

  Serial.print("Distancia: ");
  Serial.print(d);      //Enviamos serialmente el valor de la distancia
  Serial.print("cm");
  Serial.println();
  delay(100);
  /*********************************************************************************************************/
  if(d>0&&d<100){
    Serial.print("...............alerta intrusos despierta............. ");
    Serial.println();
     //generar tono de 440Hz durante 1000 ms
  tone(pinBuzzer, 440);
  digitalWrite(LED, HIGH);   
 }
  else {
   Serial.print("...............todo tranquilo............. ");
    Serial.println();
     noTone(pinBuzzer);
     digitalWrite(LED, LOW); 
  }  
}


//CONTROL ENCENDIDO LUZ SALON DE CLASES, ENCENDER CUANDO DETECTE PERSONAS

const int Trigger = 12;   //Pin digital 2 para el Trigger del sensor
const int Echo =9;//Pin digital 3 para el Echo del 
const  int  LED=5; 
void setup() {
  Serial.begin(9600);//iniciailzamos la comunicación
   pinMode(Trigger, OUTPUT); //pin como salida
  pinMode(Echo, INPUT);  //pin como entrada
  digitalWrite(Trigger, LOW);//Inicializamos e l pin con 0
    pinMode(LED, OUTPUT);

}

void loop() {
  long t; //timepo que demora en llegar el eco
  long d; //distancia en centimetros

  digitalWrite(Trigger, HIGH);
  delayMicroseconds(10);          //Enviamos un pulso de 10us
  digitalWrite(Trigger, LOW);
  
  t = pulseIn(Echo, HIGH); //obtenemos el ancho del pulso
  d = t/59;

  Serial.print("Distancia: ");
  Serial.print(d);      //Enviamos serialmente el valor de la distancia
  Serial.print("cm");
  Serial.println();
  delay(100);

  if(d>0&&d<100){
    Serial.print("encender luces");
    digitalWrite(LED, HIGH); 
    delay(30000);
  }
  else{
     Serial.print("salon vacio apagar luces luces \n");
     digitalWrite(LED, LOW); 
     delay(100);
  }
}



//PROGRAMA SONAR PARQUEADERO
const int Trigger = 12;   //Pin digital 2 para el Trigger del sensor
const int Echo =9;//Pin digital 3 para el Echo del sensor
const  int  LED=4;
const  int  LED2=5;
const  int  LED3=6;
void setup() {
   Serial.begin(9600);//iniciailzamos la comunicación
  pinMode(Trigger, OUTPUT); //pin como salida
  pinMode(Echo, INPUT);  //pin como entrada
  digitalWrite(Trigger, LOW);//Inicializamos e l pin con 0
  pinMode(LED, OUTPUT);
  pinMode(LED2, OUTPUT);
  pinMode(LED3, OUTPUT);
}


void loop() {
                      
/********************************************************************************/
  long t; //timepo que demora en llegar el eco
  long d; //distancia en centimetros

  digitalWrite(Trigger, HIGH);
  delayMicroseconds(10);          //Enviamos un pulso de 10us
  digitalWrite(Trigger, LOW);
  
  t = pulseIn(Echo, HIGH); //obtenemos el ancho del pulso
  d = t/59;

  Serial.print("Distancia: ");
  Serial.print(d);      //Enviamos serialmente el valor de la distancia
  Serial.print("cm");
  Serial.println();
  delay(100);
  /***************************************************************************/
   if(d>0&&d<20){
    Serial.print("cuidado vas a chocar ");
    Serial.println();
    
  /**************************************************************************/
  digitalWrite(LED, HIGH);   
  delay(2000); 
  digitalWrite(LED, LOW);  
                        
  }
  else{
     if(d>21&&d<40){
    Serial.print("te estas acercando al muro");
     Serial.println();
  /**************************************************************************/
  digitalWrite(LED2, HIGH);   
  delay(2000);
    digitalWrite(LED2, LOW);
     }
     else{
      Serial.print("estas a salvo ");
       Serial.println();
       /**************************************************************************/
      digitalWrite(LED3, HIGH);   
      delay(2000);
        digitalWrite(LED3, LOW);
     }  
  }
} 


//PROGRAMA CONTADOR DE PERSONAS EN UN CENTRO COMERCIAL


int LED = 13;
int TRIGGER= 11;
int ECHO= 10;
int DURACION;
int DISTANCIA;
int IZQ = 0; 
int CONTADOR = 0;
int IZQ_ANTE = 0;
int AHORA = 0;



void setup() {
  pinMode(LED, OUTPUT);
  pinMode(TRIGGER, OUTPUT);
  pinMode(ECHO, INPUT);
  Serial.begin(9600);
}

void loop(){
delay(10);
    
    digitalWrite (TRIGGER, HIGH);
    delayMicroseconds (10);
    digitalWrite (TRIGGER, LOW);
    DURACION = pulseIn (ECHO, HIGH);
    DISTANCIA = (DURACION/2) / 29.1;

  if (DISTANCIA < 30) { 
      IZQ = HIGH;
      digitalWrite (LED, HIGH);
    }
 else {
      IZQ = LOW;
      digitalWrite (LED, LOW);
    }  
 

if (IZQ ==  HIGH) { 
AHORA = 1;
}
else {
AHORA = 0;
}


if(AHORA != IZQ_ANTE){
if(AHORA == 1){
CONTADOR = CONTADOR + 1;
Serial.print("CONTADOR: "); 
Serial.println(CONTADOR);
}
}
IZQ_ANTE = AHORA;
}


//PROGRAMA ORIGINAL  TATIANA (SEMAFORO)


int TRIG = 5;
int ECO = 6;
int BUZZER = 7; //ZUMBADOR
int LED1 = 8; //LED ROJO
int LED2 = 13; //LED AMARILLO
int LED3 = 12; //LED VERDE
int DURACION;
int DISTANCIA;

 
 void setup (){
  pinMode (ECO, INPUT);
  pinMode (TRIG, OUTPUT);
  pinMode (LED1, OUTPUT);
  pinMode (LED2, OUTPUT);
  pinMode (LED3, OUTPUT);
   pinMode (BUZZER, OUTPUT);
  Serial.begin (9600); 

  
}



void loop(){
 digitalWrite (TRIG, HIGH);
 delay (15);
 digitalWrite (TRIG, LOW);
 DURACION = pulseIn (ECO, HIGH);
 DISTANCIA = DURACION / 58.2;
 Serial.println (DISTANCIA);
 delay (1000);
 
 if (DISTANCIA <= 30 && DISTANCIA >= 0){    //ROJO
  digitalWrite(LED1, HIGH);
  digitalWrite(BUZZER, HIGH);
  tone(BUZZER, 800);      
  delay(100);               
  noTone(BUZZER); 
  delay(1); 
  tone(BUZZER, 700);      
  delay(100);               
  noTone(BUZZER);
  delay(1);
  tone(BUZZER, 800);      
  delay(100);               
  noTone(BUZZER); 
  delay(1);            
  delay (DISTANCIA * 5);
  digitalWrite (LED1, LOW);
  digitalWrite (BUZZER, LOW);
 }
 //else {
  if (DISTANCIA <= 20 && DISTANCIA >= 0){      //AMARILLO
  digitalWrite(LED2, HIGH);
  digitalWrite(BUZZER, HIGH);
  tone(BUZZER, 500);      
  delay(100); 
  noTone(BUZZER); 
  delay(1);
  tone(BUZZER, 400);      
  delay(100);               
  noTone(BUZZER); 
  delay(1); 
  tone(BUZZER, 500);      
  delay(100); 
  noTone(BUZZER); 
  delay(1);
  delay (DISTANCIA * 5);
  digitalWrite (LED2, LOW);
  digitalWrite (BUZZER, LOW);
 }
 //else{
if  (DISTANCIA <= 10 && DISTANCIA >= 0){     //VERDE
  digitalWrite(LED3, HIGH);
  digitalWrite(BUZZER, HIGH);
  tone(BUZZER, 200);      
  delay(100);               
  noTone(BUZZER); 
  delay(1);
  tone(BUZZER, 100);      
  delay(1);               
  noTone(BUZZER);
  delay(100); 
   tone(BUZZER, 200);      
  delay(100);               
  noTone(BUZZER); 
  delay(1); 
  delay (DISTANCIA * 5);
  digitalWrite (LED3, LOW);
   digitalWrite (BUZZER, LOW);
   }
 }
