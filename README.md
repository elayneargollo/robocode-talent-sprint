## Solutis Talent Sprint 2020 | Robocode

+ WarRobot realizado em Java por Elayne Natália de Oliveira Argollo

### Funcionalidade da implementação

<p align="justify"> 
A estratégia principal consiste em gastar energia somente com o necessário e para isto, mesmo com um robô em seu radar, primeiramente 
o WarRobot calcula a mira e dependendo do seu nível de energia assim como o nível de energia do adversário, escolhe qual a melhor 
potência de tiro  deve ser utilizada. Além disso, como defesa, o WarRobot ao sofrer um tiro desloca-se perpendicurlamente em relação ao seu adversário a fim de não sofrer danos sucessivos.
</p>

### Pontos fortes da implementação

+ Calcula potência do tiro de acordo com energia do robô e do robô adversário
+ Movimentação perpendicular de saída ao receber um tiro
+ Cálculo de mira para tiro mais certeiro evitando gasto de energia desnecessário
+ Utiliza as informações do getX() e getY() para sair da parede

### Pontos fracos da implementação

+ Movimentação não é fluida
+ Tiro saem com defasagem devido ao tempo de cálculo da mira

### Experiência

O Talent Sprint 2020 Solutis foi um processo seletivo bastante interessante. Pelo menos, para mim, trouxe 
novidade, diversão e aprendizado: foi leve realizar a tarefa. Nesse processo aprendi a integrar o robocode
ao Eclipse, a utilizar os padrões da linguagem orientada objeto em um jogo e ampliar os horizontes das metas que podemos chegar. 

### Referências

+ Robocode API Java : [https://robocode.sourceforge.io/docs/robocode/](documentation)
+ Robocode : [https://robocode.sourceforge.io/](documentation)