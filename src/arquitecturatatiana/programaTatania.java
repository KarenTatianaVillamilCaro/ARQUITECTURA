//PROGRAMA UNICO
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