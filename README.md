## Solutis Talent Sprint 2020 | Robocode

+ WarRobot realizado em Java por Elayne Nat�lia de Oliveira Argollo

### Funcionalidade da implementa��o

<p align="justify"> 
A estrat�gia principal consiste em gastar energia somente com o necess�rio e para isto, mesmo com um rob� em seu radar, primeiramente 
o WarRobot calcula a mira e dependendo do seu n�vel de energia assim como o n�vel de energia do advers�rio, escolhe qual a melhor 
pot�ncia de tiro  deve ser utilizada. Al�m disso, como defesa, o WarRobot ao sofrer um tiro desloca-se perpendicurlamente em rela��o ao seu advers�rio a fim de n�o sofrer danos sucessivos.
</p>

### Pontos fortes da implementa��o

+ Calcula pot�ncia do tiro de acordo com energia do rob� e do rob� advers�rio
+ Movimenta��o perpendicular de sa�da ao receber um tiro
+ C�lculo de mira para tiro mais certeiro evitando gasto de energia desnecess�rio
+ Utiliza as informa��es do getX() e getY() para sair da parede

### Pontos fracos da implementa��o

+ Movimenta��o n�o � fluida
+ Tiro saem com defasagem devido ao tempo de c�lculo da mira

### Experi�ncia

O Talent Sprint 2020 Solutis foi um processo seletivo bastante interessante. Pelo menos, para mim, trouxe 
novidade, divers�o e aprendizado: foi leve realizar a tarefa. Nesse processo aprendi a integrar o robocode
ao Eclipse, a utilizar os padr�es da linguagem orientada objeto em um jogo e ampliar os horizontes das metas que podemos chegar. 

### Refer�ncias

+ Robocode API Java : [https://robocode.sourceforge.io/docs/robocode/](documentation)
+ Robocode : [https://robocode.sourceforge.io/](documentation)