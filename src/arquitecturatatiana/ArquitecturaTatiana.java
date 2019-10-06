//registradora digital bus intermunicipal
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
//sensor intrusos->sonar y encender luz
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
//control encendido de luz de un salon clase encender cuando detecte persona
onst int Trigger = 12;   //Pin digital 2 para el Trigger del sensor
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
//programa sonar parqueadero
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
