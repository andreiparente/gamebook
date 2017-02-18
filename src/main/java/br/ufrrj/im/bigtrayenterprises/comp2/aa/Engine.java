package br.ufrrj.im.bigtrayenterprises.comp2.aa;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.AICharacter;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Character;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Player;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.BlankChoice;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.Choice;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Events.BattleEvent;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Events.BlankEvent;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Events.Event;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Items.Item;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Items.ItemType;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Skills.AutoAttack;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Skills.Skill;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Engine {
    public static Random random = new Random();

    public static IOSource source;

    public void run() {
        Book book = Engine.finalBuque();

        source.printString(book.showHistoryBook());

        Scanner in = new Scanner(System.in);

        do {
            source.printString(book.showHistory());

            for (Choice choice : book.nextEvents()) {
                source.addChoice(choice);
            }

            int i;
            do {
                i = source.getChoice();
            } while (!book.nextEvent(i));
        } while (!book.isTheEnd());

        source.printString(book.showHistory());
    }

    public static Book finalBuque() {
        Attributes attr = new AttributeBuilder()
                .setAgility(1)
                .setStrength(1)
                .setResistance(1)
                .setArmor(4)
                .setFirepower(1)
                .createAttributes();

        Player player = new Player(attr);

        AICharacter invasorDeMundos = new AICharacter(
                new AttributeBuilder()
                        .setAgility(1)
                        .setArmor(8)
                        .setFirepower(1)
                        .setResistance(8)
                        .setStrength(3)
                        .createAttributes()
        ) {
            Skill ataque = new AutoAttack();

            @Override
            public Usable chooseUsable(Character enemy) {
                return ataque;
            }
        };

        AICharacter cultista = new AICharacter(
                new AttributeBuilder()
                        .setAgility(1)
                        .setArmor(2)
                        .setFirepower(2)
                        .setResistance(1)
                        .setStrength(2)
                        .createAttributes()
        ) {
            Skill ataque = new AutoAttack();

            @Override
            public Usable chooseUsable(Character enemy) {
                return ataque;
            }
        };

        AICharacter zumbi = new AICharacter(
                new AttributeBuilder()
                        .setAgility(1)
                        .setArmor(1)
                        .setFirepower(1)
                        .setResistance(5)
                        .setStrength(1)
                        .createAttributes()
        ) {
            Skill ataque = new AutoAttack();

            @Override
            public Usable chooseUsable(Character enemy) {
                return ataque;
            }
        };

        AICharacter monstro = new AICharacter(
                new AttributeBuilder()
                        .setAgility(1)
                        .setArmor(1)
                        .setFirepower(3)
                        .setResistance(7)
                        .setStrength(2)
                        .createAttributes()
        ) {
            Skill ataque = new AutoAttack();

            @Override
            public Usable chooseUsable(Character enemy) {
                return ataque;
            }
        };

        AICharacter monstroFraco = new AICharacter(
                new AttributeBuilder()
                        .setAgility(1)
                        .setArmor(1)
                        .setFirepower(3)
                        .setResistance(5)
                        .setStrength(2)
                        .createAttributes()
        ) {
            Skill ataque = new AutoAttack();

            @Override
            public Usable chooseUsable(Character enemy) {
                return ataque;
            }
        };

        AICharacter monstroMuitoFraco = new AICharacter(
                new AttributeBuilder()
                        .setAgility(2)
                        .setArmor(2)
                        .setFirepower(2)
                        .setResistance(2)
                        .setStrength(2)
                        .createAttributes()
        ) {
            Skill ataque = new AutoAttack();

            @Override
            public Usable chooseUsable(Character enemy) {
                return ataque;
            }
        };

        Item tacape =
                new Item(
                        "Tacape",
                        new AttributeBuilder()
                                .setAgility(1)
                                .setStrength(0)
                                .setResistance(0)
                                .setArmor(2)
                                .setFirepower(4)
                                .createAttributes(),
                        6,
                        ItemType.WEAPON
                );

        Item presa30 =
                new Item(
                        "Dente de Adaga",
                        new AttributeBuilder()
                                .setAgility(3)
                                .setStrength(0)
                                .setResistance(0)
                                .setArmor(0)
                                .setFirepower(2)
                                .createAttributes(),
                        3,
                        ItemType.WEAPON
                );

        Item morningStar =
                new Item(
                        "Morningstar",
                        new AttributeBuilder()
                                .setAgility(0)
                                .setStrength(0)
                                .setResistance(0)
                                .setArmor(1)
                                .setFirepower(5)
                                .createAttributes(),
                        10,
                        ItemType.WEAPON
                );

        Item manto =
                new Item(
                        "Poção de Vida",
                        new AttributeBuilder()
                                .setAgility(2)
                                .setStrength(0)
                                .setResistance(0)
                                .setArmor(1)
                                .setFirepower(0)
                                .createAttributes(),
                        5,
                        ItemType.ARMOR
                );

        Item armadura =
                new Item(
                        "Armadura de Couro",
                        new AttributeBuilder()
                                .setAgility(1)
                                .setStrength(0)
                                .setResistance(3)
                                .setArmor(3)
                                .setFirepower(0)
                                .createAttributes(),
                        20,
                        ItemType.ARMOR
                );

        Item cordao =
                new Item(
                        "Cordão de Ritos",
                        new AttributeBuilder()
                                .setAgility(2)
                                .setStrength(2)
                                .setResistance(0)
                                .setArmor(0)
                                .setFirepower(0)
                                .createAttributes(),
                        2,
                        ItemType.AMULET
                );

        Event end2 = new BlankEvent(
                new ArrayList<>(),
                "\n\n\n\n\n\n\n\nVocê decide ficar e enfrentar o pior. \n" +
                        "Com o passar dosanos que se pareceram ali, vocẽ ainda não se recorda de quem você já foi, mas entende o peso da sua escolha: seu mundo está a salvo, sua morte seria a chave para a\n" +
                        "invasão de vis criaturas que destruiriam tudo.\n" +
                        "O mundo nunca saberá do perigo que passou e nem do seu trágico héroi que vive até hoje entre o nada."
        );

        Event end1 = new BlankEvent(
                new ArrayList<>(),
                "\n\n\n\n\n\n\n\nVocê a abre e a luz solar te recebe... Sem mais escuridão..."
        );

        BlankChoice abrirPortaFinal = new BlankChoice("Abrir a porta", end1);

        ArrayList<Choice> escolhas = new ArrayList<>();
        escolhas.add(abrirPortaFinal);

        Event matouInvasor = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nO Invasor de Mundos sucumbe. Está morto, sua existência é apagada da realidade.\n" +
                "É possível ver tábuas debaixo dos seus pés, após andar um pouco, você sai da escuridão. Você está de volta a ponte pênsil, bem próximo à corda que conecta o teto e o lago.\n" +
                "Você se agarra à corda e escala ela. Após um tempo, você percebe que escalou a corda do poço, está de volta à sala da lamparina. O local parece está totalmente vazio e você\n" +
                "percebe uma porta que não estava presente ali antes."
        );

        BattleEvent combateInvasor = new BattleEvent(matouInvasor, invasorDeMundos, player);

        BlankChoice enfrentarInvasor = new BlankChoice("Enfrentar o Invasor de Mundos", combateInvasor);

        escolhas = new ArrayList<>();
        escolhas.add(enfrentarInvasor);

        Event matarOInvasorDeMundos = new BlankEvent(
             escolhas,
            "\n\n\n\n\n\n\n\nVocê desce uma escadaria em espiral presente no templo. Após um tempo descendo as escadas, novamente, você chega na escuridão total, no nada. Não mais é possível ver a\n" +
                    "escadaria. Por um tempo você olha procurando seu oponente, até que é avistado um ponto no meio da imensidão negra. O ponto vai ficando maior, tendo sentido e forma, está\n" +
                    "se aproximando de vocẽ. Uma criatura quadrúpede, cor marrom, peluda, com cerca de três metros de altura, grandes olhos, seus membros extremamente finos, parece impossível\n" +
                    "que surportem aquele corpo gigante. Uma criatura horrenda. De seu peito, um braço mais longo que os outros membros surge entre os pelos, segurando uma espada gigante.\n" +
                    "Uma criatura incompressível, indescritível!"
        );

        BlankChoice enfrentarInvasor2 = new BlankChoice("Retornar ao templo e matar o Invasor de Mundos", matarOInvasorDeMundos);
        //BlankChoice treinar = new BlankChoice("Treinar novamente", treinarEvento);

        escolhas = new ArrayList<>();
        //escolhas.add(treinar);
        escolhas.add(enfrentarInvasor2);

        Event treinoCompleto = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nTreino completo. A criatura deixa cair uma armadura ao morer, você tenta equipar. O que será feito agora?",
                player, armadura, 0
        );

        //BattleEvent treinar1 = new BattleEvent(treinoCompleto, cultista, player);
        BattleEvent treinar2 = new BattleEvent(treinoCompleto, zumbi, player);
        //BattleEvent treinar3 = new BattleEvent(treinoCompleto, monstro, player);

        BlankChoice enfrentarTreino = new BlankChoice("Enfrentar oponente", treinar2);

        escolhas = new ArrayList<>();
        escolhas.add(enfrentarTreino);

        Event treinarEvento = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nAndando por este novo mundo, você encontra um novo oponente."
        );

        BlankChoice treinar = new BlankChoice("Treinar", treinarEvento);
        enfrentarInvasor = new BlankChoice("Enfrentar o Invasor de Mundos", matarOInvasorDeMundos);

        escolhas = new ArrayList<>();
        escolhas.add(treinar);
        escolhas.add(enfrentarInvasor);

        Event invasaoDeMundo = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê decide ser transportado para outro mundo para acabar com aquela ameaça. Toda a escuridão começa a desaparecer e a luz surge. Cada vez mais você sente as coisas, vê as\n" +
                        "coisas... Após um tempo, você percebe estar num grandioso templo, com uma arquiterura nada familiar. Uma criatura humanoide, gorda, cheia de bolhas pelo corpo, que se arrasta\n" +
                        "pelo chão te saúda. Ele explica qual será seu destino: o Invasor de Mundos te espera no andar inferior, mas deseja uma luta pelo menos desafiadora, então permitiu que cada \n" +
                        "ser daquele mundo te matasse, para que você possa treinar. No templo, porém, isso era proibido. O que será feito?"
        );

        BlankChoice ficar = new BlankChoice("Ficar", end2);
        BlankChoice invadirMundo = new BlankChoice("Invadir mundo", invasaoDeMundo);

        escolhas = new ArrayList<>();
        escolhas.add(ficar);
        escolhas.add(invadirMundo);

        Event dialogo4 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\n- Infelizmente, não posso invadir seu mundo para aniquilá-lo, mas você caiu na minha armadilha, possuindo somente duas escolhas: invada meu mundo para que eu te aniquile ou \n" +
                        "continue aí para o resto da eternidade."
        );

        BlankChoice continuar = new BlankChoice("...", dialogo4);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event dialogo3 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\n- Vejo que mexeram com a sua mente, você nem se lembra de quem é. Te deixar nessas condições dentro do vazio perpétuo é muito tentador, te assistir torna-se um miserável insano\n" +
                        "após passar a eternidade aqui. Porém, isso não colocará meus planos em curso..."
        );

        continuar = new BlankChoice("...", dialogo3);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event dialogo2 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê para de andar. Não há para onde ir. Você espera, simplesmente. E, então, é escutado:\n" +
                        "- Somente o que me falta é te matar... Somente isso... Toda essa seita profana foi arruinada, todos sacrificados propriamente pelos meus lacaios. Mas você não. Você não morre!"
        );

        continuar = new BlankChoice("Parar", dialogo2);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event dialogo = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nNão se enxerga mais nada, nem a madeira da ponte debaixo de você, nem a chuva cor de rosa, porém você é capaz de se ver perfeitamente, suas mãos, suas pernas... Você para e \n" +
                        "olha para trás, há somente escuridão. Você anda em todas as direções e aí percebe que não está mais em uma ponte. Você não sente nada debaixo dos seus pés. Não há nada aqui. \n" +
                        "Somente escuridão."
        );

        continuar = new BlankChoice("Tentar continuar", dialogo);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event caminhandoNaPonte = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê então decide prosseguir para o único caminho disponível, à direita da estátua o corredor continua, mas logo termina, dando lugar a uma ponte pênsil sobre um abismo dentro de uma \n" +
                        "caverna colossal. Mesmo com o teto da caverna a muitos metros de altura, percebe-se que ele está coberto por um tipo de musgo vermelho, e em certos pontos, um líquido rosa escuro\n" +
                        "é gotejado, o que faz parecer que está chuviscando dentro do local. Andando pela ponte, você percebe que lá embaixo, existe um grande lago formado pelo líquido, dezenas de corpos \n" +
                        "flutuam por ele, e uma corda próxima a você conecta o teto ao lago. A cada passo dado na ponte, você sente que a caverna fica mais escura, você não encherga mais o vermelho do\n" +
                        "teto, não se vê mais o rosa abaixo de seus pés. Mais passos são dados, você não enxerga mais do que alguns metros do caminho à frente. "
        );

        continuar = new BlankChoice("Prosseguir", caminhandoNaPonte);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event fezNada = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê não fez nada."
        );

        Event girouAleatoriamente = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nEm algum momento, você gira uma costela que aciona mecanismos presentes na parede atrás da estátua, que revela um buraco. Nele, há uma garrafa com um líquido rosa escuro. Você \n" +
                        "bebe o conteúdo da garrafa e recupera vida.",
                player, -10
        );

        Event formouUmV = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nAo fazer isso, mecanismos dentro da estátua são acionados e expressão do rosto dela muda, seus olhos e boca são abertos, revelendo buracos. De repente, uma espécie de névoa\n" +
                        "roxa sai desses buracos e ela fica a sua volta. Você sente seu corpo, de alguma forma, absorvendo aquela névoa para dentro até que não haja mais dela presente."
                // PEGADOR DE SKILL AKI ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^~
        );

        BlankChoice fazerNada = new BlankChoice("Fazer nada", fezNada);
        BlankChoice rotacionarAleatoriamente = new BlankChoice("Rotacionar as costelas aleatoariamente", girouAleatoriamente);
        BlankChoice rotacionarEmV = new BlankChoice("Rotacionar as costelas para formar um V ao contrário", formouUmV);

        escolhas = new ArrayList<>();
        escolhas.add(fazerNada);
        escolhas.add(rotacionarAleatoriamente);
        if(player.getGarilho1()) {
            escolhas.add(rotacionarEmV);
        }

        Event olhandoEstatua = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê passa pela porta e se depara com um elevador, com a única opção é descer após subir na plataforma. Ao chegar no final dela, depois de muito tempo, você se encontra num \n" +
                        "corrredor, porém, suas paredes são rochosas, parece que você está em uma caverna de verdade, o local é bem iluminado por tochas de bambu. Pelo corredor, há a presença de corpos (vestindo \n" +
                        "mantos) que estão brutalizados e mutilados, uma onda de violência havia inundado o local antes. No final do corredor, há um tipo de estátua, representa um humano da cintura para \n" +
                        "cima, porém totalmente esfolado, com a barriga aberta, as tripas saindo, duas costelas expostas. Mesmo sendo de mal gosto, você reconhece que é preciso habilidade para se esculpir \n" +
                        "algo assim. O rosto tem os olhos e boca fechadas. Você nota que de alguma forma, a posição das costelas podem ser modificadas. O que será feito?"
        );

        continuar = new BlankChoice("Prosseguir", olhandoEstatua);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event bracoLancado = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê silenciosamente se aproxima de um braço mutilado, pega ele e o lança. Ele acaba aterrissando perto do encapuzado, criando um barulho que assusta e chama a atenção de\n" +
                        "todos. As criaturas ao verificarem rapidamente o braço jogado, que não notavam o provável sobrevivente de um massacre, percebem agora a figura que estava se fingindo de\n" +
                        "morta. Não houve tempo de reação para o encapuzado, as criaturas simplesmente pularam para cima dele com ferocidade, dando golpes brutais, esmagando ossos, rasgando sua\n" +
                        "pele. Com a distração perfeita, você decide sair dali logo, seguindo para a outra porta enquanto os gritos de dor ainda são ouvidos."
        );

        Event atacandoSorrateiramente3 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nCom ambas criaturas mortas, o ser encapuzado se aproxima de você. Ele lhe agradece e te dá um manto igual aos dos outros e segue para a outra porta. Após um tempo\n" +
                        "você vai pelo mesmo caminho. ",
                player, manto, 0
        );

        BattleEvent combateMonstro = new BattleEvent(atacandoSorrateiramente3, monstro, player);

        continuar = new BlankChoice("Combater", combateMonstro);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event atacandoSorrateiramente2 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nApós matar a criatura, a outra se aproxima de você para um combate."
        );

        BattleEvent combateMonstroFraco = new BattleEvent(atacandoSorrateiramente2, monstroFraco, player);

        continuar = new BlankChoice("Combater", combateMonstroFraco);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event atacandoSorrateiramente = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nA passos cautelosos, você se aproxima de trás da criatura mais próxima e realiza um ataque corpo-a-corpo com sua arma, realizando dano surpresa a ela. Após se recuperar do\n" +
                        "ataque, a criatura se prepara para um confronto."
        );

        continuar = new BlankChoice("Prosseguir", olhandoEstatua);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event esperou2 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nCom a criatura morta, você vai em direção a porta em seguida."
        );

        combateMonstro = new BattleEvent(esperou2, monstro, player);

        continuar = new BlankChoice("Combater", combateMonstro);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event esperou = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê fica imóvel, imperceptível para as criaturas. Como elas ficam andando pela sala, cada vez mais acabam chegando mais próximo de você ou do encapuzado. É inevitável que\n" +
                        "um de vocês será descoberto. A sorte sorri para você e as criaturas encontram o encapuzado antes. Entendendo que foi descoberto, ele se lança contra as criaturas de forma\n" +
                        "desesperada. De alguma forma, ele consegue aparentemente matar uma delas, porém logo depois a sobrevivente golpeia ele e continua, até mesmo quando já não havia mais reação. \n" +
                        "A criatura, então, cessa os golpes e, como num surto de percepção, olha fixamente a você. Ele se aproxima correndo e um combate é iniciado."
        );

        BlankChoice atacarSorrateiramente = new BlankChoice("Atacar sorrateiramente", atacandoSorrateiramente);
        BlankChoice esperar = new BlankChoice("Esperar", esperou);
        BlankChoice lancarBraco = new BlankChoice("Lançar um braço arrancado próximo para perto do encapuzado", bracoLancado);

        escolhas = new ArrayList<>();
        escolhas.add(atacarSorrateiramente);
        escolhas.add(esperar);
        escolhas.add(lancarBraco);

        Event finalizandoCorredor = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nEm seguida, você chega ao final do corredor, onde há uma porta. Ao abrir e passar por ela, você se encontra numa sala grande, com algumas janelas iluminando o local com a luz\n" +
                        "do luar. Você vê poças de sangue por todo o chão, corpos aparentemente humanos vestindo manto (os mesmos que os outros usavam na sala com a lamparina) jogados pela sala. \n" +
                        "Alguns com as vestes muito rasgados, outros mutilados, faltando pernas e braços, todos mortos. Duas grandes criaturas humanoides estão andando pela sala e não notaram sua\n" +
                        "presença, possuem uns dois metros e meio, são extremamente magras e seus braços longos fazem as pontas dos seus dedos alcançarem o meio de suas canelas. A cor da pele é um \n" +
                        "cinza escuro, um vermelho de sangue está presente nas mãos de cada. Você avista uma outra figura encapuzada e de manto caída no chão, mas ela está vivo, está se figindo de \n" +
                        "morta, certamente para não ser encontrada pelas criaturas. A iluminaçã fraca local esconde vocês dois temporariamente. Há uma porta no outro lado da sala. O que será feito?"
        );

        continuar = new BlankChoice("Prosseguir", finalizandoCorredor);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event ignorou3 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê simplesmente ignora as incríves possibilidades que puxar a tocha-alavanca iram lhe trazer."
        );

        Event puxou3 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nAo fazer isso, você escuta barulhos, que surgem por dentro das paredes e do teto, até que de repente, uma parte da parede do corredor se abre de forma mecânica, revelando\n" +
                        "uma morningstar. Você tenta equipar o item",
                player, morningStar, 0
        );

        BlankChoice ignorar = new BlankChoice("Ignorar alavanca", ignorou3);
        BlankChoice puxar = new BlankChoice( "Puxar alavanca", puxou3);
        escolhas = new ArrayList<>();
        escolhas.add(ignorar);
        escolhas.add(puxar);

        Event alavanca3 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nE mais uma vez, você se depara com outra tocha-alavanca. O que será feito?"
        );

        continuar = new BlankChoice("Prosseguir", alavanca3);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event ignorou2 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê simplesmente ignora as possibilidades que puxar a tocha-alavanca poderia lhe trazer."
        );

        Event puxou2 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nAo fazer isso, você escuta barulhos, que surgem por dentro das paredes e do teto, até que de repente, chamas surgem de pequenos buracos no teto e vão em sua direção. \n" +
                        "Você consegue até escapar da armadilha, mas não totalmente ileso, o calor te machucou bastante.",
                player, 10
        );

        ignorar = new BlankChoice("Ignorar alavanca", ignorou2);
        puxar = new BlankChoice( "Puxar alavanca", puxou2);
        escolhas = new ArrayList<>();
        escolhas.add(ignorar);
        escolhas.add(puxar);

        Event alavanca2 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nContinuando no corredor, você se depara com outra tocha-alavanca. O que será feito?"
        );

        continuar = new BlankChoice("Prosseguir", alavanca2);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event ignorou = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê ignora as possibilidades que puxar a tocha-alavanca poderia lhe trazer."
        );

        Event puxou = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nAo fazer isso, você escuta barulhos, que surgem por dentro das paredes e do teto, até que de repente, flechas surgem de pequenos buracos no teto e vão em sua direção. \n" +
                        "Você consegue até escapar da armadilha, mas não totalmente ileso, uma das flechas machucou sua perna.",
                player, 5
        );

        ignorar = new BlankChoice("Ignorar alavanca", ignorou);
        puxar = new BlankChoice( "Puxar alavanca", puxou);
        escolhas = new ArrayList<>();
        escolhas.add(ignorar);
        escolhas.add(puxar);

        Event alavanca = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nAo abrir a porta, você se encontra em outro corredor, porém este é bem iluminado por tochas que estão presas às paredes. Uma próxima a você parece que pode ser puxada como\n" +
                        "uma alavanca. O que será feito?"
        );

        continuar = new BlankChoice("Você volta para a sala anterior e resolve abrir a porta da direita", alavanca);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event naEsquerdaSemLuz = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nAo abrir a porta, você percebe que voltará a andar por um corredor não-iluminado. Após andar um pouco pela escuridão, você ouve uma respiração pesada e ameaçadora. \n" +
                        "Você para e avalia a situação, um grunhido curto é ouvido a pouco metros de você, provavelmente da mesma fonte da respiração. Você acha melhor retornar à sala anterior \n" +
                        "e seguir pela outra porta."
        );

        continuar = new BlankChoice("Prosseguir", olhandoEstatua);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event atacouOTecido = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê empunha sua arma e decide atacar aquele amontoado esquisito e vermelho. Depois de cada golpe dado, uma explosão do líquido rosa escuro é criada com o impacto.\n" +
                        "Mais e mais, o tecido parece estar caindo, se desgrudando da porta. Você decide colocar sua arma entre a base da pirâmide e a superfície da porta para arrancá-la.\n" +
                        "Após empurrar, movimentar, sacudir, todo o amontoado cai no chão e a maçaneta é visível. Você a gira. "
        );

        Event colocouOBraco = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê coloca primeiramente a mão dentro daquela coisa asquerosa e cria coragem para continuar empurrando sua mão até à maçaneta. De repente, você sente uma dor\n" +
                        "intensa, como se a pirâmide estivesse se comprimindo e, dentro dela, houvessem dentes que estão perfurando sua pele. Você sente a maçaneta e a gira, a porta é\n" +
                        "aberta, arrancando alguns musgos que estavam entre a parede do corredor e a superfície da porta. Você decide puxar seu braço de volta, mas sente que isso vai \n" +
                        "rasgar todo seu braço após alguns centímetros sairem. Você, então, retorna todo o braço para dentro do buraco e puxa ele novamente até o limite de rasgá-lo. \n" +
                        "Repetindo esse processo, os dentes parecem estarem sendo muito forçados e sendo arrancados e cada vez mais você sente seu braço sendo soltado. Após algum tempo, \n" +
                        "você finalmente livra seu braço daquilo, trazendo alguns dentes que ficaram presos em sua pele. Um dente, por sorte, não perfurou sua pele profundamente, mas\n" +
                        "mesmo assim fora arrancado no processo, caindo no chão, uma presa de cerca de 35 centímetros, com o formato das presas de um grande predador. Você tenta equipar \n" +
                        "o item",
                player, presa30, 5
        );

        BlankChoice colocarBraco = new BlankChoice("Colocar o braço lá dentro e alcançar a maçaneta", colocouOBraco);
        BlankChoice atacarTecido = new BlankChoice("Atacar o tecido e tentar tirá-lo", atacouOTecido);
        escolhas = new ArrayList<>();
        escolhas.add(colocarBraco);
        escolhas.add(atacarTecido);

        Event monstroMorre = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nA criatura cai morta no chão. Você continua andando pelo corredor e as características destes tornam-se iguais ao anterior, fedido, chão molhado e fofo, mas dessa vez\n" +
                        "você vê o motivo: as paredes, os chão, o teto, sendo cada vez mais cobertos por uma espécie de musgo com bolor de cor vermelho-sangue. De fato, a concetração daquilo\n" +
                        "em certos pontos formavam tecidos parecidos com a carne de mamíferos e em outros casos, ficavam claros, lembrando a epiderme de um ser. Em alguns pontos, podia-se ver que\n" +
                        "secretavam um líquido rosa escuro, o que molhava o chão. Há uma porta no final do corredor, mas o musgo forma um tecido, que se assemelha a uma pirâmide circular e um\n" +
                        "buraco escuro na ponta dela, onde ficaria a maçaneta. A largura do buraco é grande o bastante para colocar o braço inteiro. O que será feito?"
        );

        combateMonstro = new BattleEvent(monstroMorre, monstro, player);

        continuar = new BlankChoice("Combater", combateMonstro);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event chamandoAtencao = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nEmbora esta fosse uma péssima ideia, você a fez mesmo assim, produzindo barulhos para chamar a atenção da criatura. A criatura se vira para você e começa a correr \n" +
                        "em sua direção. Quando vocês estão próximos o bastante, um combate se inicia."
        );

        BattleEvent combateMonstroMuitoFraco = new BattleEvent(monstroMorre, monstroMuitoFraco, player);

        continuar = new BlankChoice("Combater", combateMonstroMuitoFraco);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event atacandoAgressivamente = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê se posiciona e começa a correr em direção a criatura. Ela escuta os passos e se vira rapidamente, mas ela não estava preparada para o golpe com uma força \n" +
                        "tão alta que veio a seguir. Ela chega a cair no chão, mas em alguns instantes ela se levanta para te atacar."
        );

        combateMonstroFraco = new BattleEvent(monstroMorre, monstroFraco, player);

        continuar = new BlankChoice("Combater", combateMonstroFraco);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event atacandoSorrateiramente4 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nA passos cautelosos, você se aproxima de trás da criatura e realiza um ataque corpo-a-corpo com sua arma, realizando dano surpresa a ela. Após se recuperar do\n" +
                        "ataque, a criatura se prepara para um confronto."
        );

        BlankChoice atacarSorrateiramente4 = new BlankChoice("Realizar um ataque sorrateiro", atacandoSorrateiramente4);
        BlankChoice atacarAgressivamente = new BlankChoice("Correr e atacar com grande impulso", atacandoAgressivamente);
        BlankChoice chamarAtencao = new BlankChoice("Chamar atenção da criatura", chamandoAtencao);
        escolhas = new ArrayList<>();
        escolhas.add(atacarSorrateiramente4);
        escolhas.add(atacarAgressivamente);
        escolhas.add(chamarAtencao);

        Event toTheLeft = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nAo abrir a porta, você percebe que estará andando por outro corredor escuro, porém, dessa vez, sua lamparina iluminará seu caminho. Após andar um pouco, é possível\n" +
                        "ouvir uma respiração pesada a frente. Mais alguns passos dados e uma grande criatura humanoide é avistada, está de costas para você, parada, possui uns dois metros e \n" +
                        "meio, é extremamente magra e seus braços longos fazem as pontas dos seus dedos alcançarem o meio de suas canelas. A cor da pele é um cinza escuro, um vermelho de\n" +
                        "sangue está presente em suas mãos e no chão a volta dele. O que será feito?"
        );

        BlankChoice direita = new BlankChoice("Ir a porta da direita ", alavanca);
        BlankChoice esquerda = new BlankChoice("Ir a porta da esquerda ", naEsquerdaSemLuz);
        if(player.getGarilho2())
            esquerda = new BlankChoice("Ir a porta da esquerda ", toTheLeft);
        escolhas = new ArrayList<>();
        escolhas.add(direita);
        escolhas.add(esquerda);

        Event olhandoSala = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nA presença de mais duas portas na sala chamam sua atenção. Uma na parede esquerda e outra na parede da direita. O que será feito?"
        );

        continuar = new BlankChoice("Prosseguir", olhandoSala);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event cagouParaLamparina = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVendo a possibilidade de cair em um abismo, você decide que é melhor não arriscar a vida por uma lamparina."
        );

        Event pegouLamparina = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nCom coragem, você decide subir na estrutura. Após ficar em pé em cima dela, o arrenpedimento surge ao perceber que se aquilo ruir, um abismo negro é o que lhe espera, não\n" +
                        "é possível saber o quão fundo o poço é, nem visualizar o balde. Com alguns cuidadosos passos, porém, a lamparina é alcançada, retirada do guancho e fixada ao seu cinto,\n" +
                        "podendo ser utilizada e deixando as mãos livres.",
                        false, player
        );

        BlankChoice cagarParaLamparina = new BlankChoice("Não se arriscar", cagouParaLamparina);
        BlankChoice pegarLamparina = new BlankChoice("Tentar pegar lamparina", pegouLamparina);
        escolhas = new ArrayList<>();
        escolhas.add(cagarParaLamparina);
        escolhas.add(pegarLamparina);

        Event naSala = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê repara que há uma lamparina, que está pendurada por um guancho no teto, iluminando vagamente a sala. Embaixo dela, uma espécie de poço muito fundo se encontra ali. A \n" +
                        "estrutura de madeira que sustenta a roldana, a corda e o balde (aparentemente está jogado no fundo do poço) parece frágil, mas você sente que é possível subir nela para \n" +
                        "alcançar a lamparina. O que será feito? "
        );

        continuar = new BlankChoice("Prosseguir", naSala);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event abriuBemDevagar = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê lentamente abre a porta, com muito cuidado. Assim que é possível, você decide entrar em silêncio. Duas figuras encapuzadas, vestindo mantos, se encontram no local. Uma \n" +
                        "está a alguns metros de distância, enquanto a outra está próxima da porta, quase escondida por causa da rotação que foi feita na abertura, ambas não notaram sua presença. \n" +
                        "Você pode explorar a sala livremente."
        );

        Event abriuNormalmente3 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nCom os dois oponentes derrotados, você inspeciona a sala."
        );

        BattleEvent combateCultista = new BattleEvent(abriuNormalmente3, cultista, player);

        continuar = new BlankChoice("Combater", combateCultista);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event abriuNormalmente2 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nEm seguida, a outra figura te ataca."
        );

        combateCultista = new BattleEvent(abriuNormalmente2, cultista, player);

        continuar = new BlankChoice("Combater", combateCultista);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event abriuNormalmente= new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nA velocidade da porta quando aberta produz estalos e rangidos altos, que informam sua presença a duas figuras encapuzadas, de mantos. A mais próxima da porta te ataca."
        );

        continuar = new BlankChoice("Prosseguir", naSala);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event abriuRapidamente2 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nUm oponente derrotado e outro caído, você está seguro."
        );

        combateCultista = new BattleEvent(abriuRapidamente2, cultista, player);

        continuar = new BlankChoice("Combater", combateCultista);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event abriuRapidamente = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nA força aplicada na abertura acaba por derrubar uma figura encapuzada, de manto, que estava próximo a porta. O barulho feito, porém, alerta uma outra figura que estava\n" +
                        "presente no local. Ela te ataca."
        );

        BlankChoice abrirRapidamente = new BlankChoice("Abrir rapidamente", abriuRapidamente);
        BlankChoice abrirNormalmente = new BlankChoice("Abrir normalmente", abriuNormalmente);
        BlankChoice abrirBemDevagar = new BlankChoice("Abrir bem devagar", abriuBemDevagar);

        escolhas = new ArrayList<>();
        escolhas.add(abrirNormalmente);
        escolhas.add(abrirBemDevagar);
        escolhas.add(abrirRapidamente);

        Event antesDaSala = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nSeguindo em frente, algo impede sua passagem, você chegou ao fim do corredor. Uma fraca luz que surge pelas frestas chama a atenção para uma porta a direita, ela está \n" +
                        "entreaberta. Você decide entrar no local. O que será feito?"
        );

        continuar = new BlankChoice("Prosseguir", antesDaSala);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event cagouParaParede = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê não acha uma boa ideia encostar na parede e decide não fazê-lo."
        );

        Event encostouNaParede = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nAo encostar a mão na parede, você sente como se estivesse tocando em musgo bem úmido. Depois de alguns passos, você sente uma espécie de buraco, com algo pontiagudo ao\n" +
                        "redor dele. Você decide tirar a mão dali após sentir que um pedacinho da sua mão foi arrancado repentinamente.",
                player, 5
        );

        BlankChoice cagarParaParede = new BlankChoice("Não tocar na parede e continuar andando", cagouParaParede);
        BlankChoice encostarNaParede = new BlankChoice("Colocar a mão na parede para sentir se há uma porta", encostouNaParede);
        escolhas = new ArrayList<>();
        escolhas.add(cagarParaParede);
        escolhas.add(encostarNaParede);

        Event noCorredor = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nAgora, encontra-se em um corredor, a entrada do quarto em que estava antes está atrás de você. À sua direita, a escuridão se espalha livremente, não é possível saber quão longo \n" +
                        "é o corredor e, infelizmente, é o único caminho a ser seguido. A cada passo dado, você percebe pequenos barulhos, como se fossem algo gosmento sendo esfregado em outra coisa \n" +
                        "parecida. Os barulhos se mantêm constante. Você sente o cheiro do local ficar mais fedido, como se houvesse muito mofo ali. O chão cada vez mais parece molhado e fofo. As mudanças \n" +
                        "no ambiente e a escuridão te deixam estressado, talvez haja uma porta por perto. O que será feito?"
        );

        continuar = new BlankChoice("Prosseguir", noCorredor);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event naoTocouEmNada = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê simplesmente observa a criatura horrenda. Se era humano, como poderia ter ficado desse jeito? E ainda viva até esse momento? Porém, nota-se que, lentamente, a \n" +
                        "respiração dela torna-se mais fraca, até deixar de existir. Você nota que dois ossos da costela, um de cada lado, estão espostos e formam uma espécie de V de cabeça para\n" +
                        "baixo. Você se retira do local.",
                true, player
        );

        Event puxouComForca = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê posiciona alguns dedos cobrindo a corrente e, repentinamente, puxa com grande força. A criatura solta um grito de agonia que cessa tão rápido quanto começou, \n" +
                        "aparentemente o seu ato a matou. Um cordão era o que estava nas entranhas. Você equipa o item e sai do local.",
                player, cordao, 0
        );

        Event puxouDevagar2 = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nA criatura cai morta no chão do local e a corrente não pode ser mais vista. A naúsea te impede de procurá-la no corpo nojento da criatura. Você sai do local."
        );

        BattleEvent combateZumbi = new BattleEvent(puxouDevagar2, zumbi, player);

        continuar = new BlankChoice("Combater", combateZumbi);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event puxouDevagar = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nAo ir puxando lentamente a corrente, os sons da criatura tornam-se gritos de agonia. Esta, então, se levanta e te ataca desesperadamente."
        );

        BlankChoice puxarDevagar = new BlankChoice("Puxar a corrente bem devagar", puxouDevagar);
        BlankChoice puxarComForca = new BlankChoice("Puxar a corrente rapidamente e com força", puxouComForca);
        BlankChoice naoTocarEmNada = new BlankChoice("Não tocar em nada", naoTocouEmNada);
        escolhas = new ArrayList<>();
        escolhas.add(puxarDevagar);
        escolhas.add(puxarComForca);
        escolhas.add(naoTocarEmNada);

        Event foiAteACama = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nA cada passo dado, você reconhece melhor a forma do ser. Parece ser um humano que está deitado na cama, mas não possui pele, fora absurdamente esfolado, seu abdômen está \n" +
                        "completamente exposto, com as tripas se espalhando pelas pernas. Isso lhe causa bastante desconforto. Os olhos estão fechados, mas a boca aberta continua a emitir sons \n" +
                        "horríveis. Entre as entranhas, vê-se um pedaço de uma pequena corrente. O que será feito?"
        );

        continuar = new BlankChoice("Prosseguir", noCorredor);
        escolhas = new ArrayList<>();
        escolhas.add(continuar);

        Event escondeuEFugiu= new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê pula a cama e protege-se atrás dela. A criatura torna-se silenciosa novamente, você aproveita e foge dali."
        );

        BlankChoice irAteACama = new BlankChoice("Ir à cama da direita", foiAteACama);
        BlankChoice esconderEFugir = new BlankChoice("Esconder-se atrás atrás da cama a esquerda e fugir em seguida", escondeuEFugiu);
        escolhas = new ArrayList<>();
        escolhas.add(irAteACama);
        escolhas.add(esconderEFugir);

        Event inicial = new BlankEvent(
                escolhas,
                "\n\n\n\n\n\n\n\nVocê acorda em um local escuro, iluminado por tochas. Você se encontra em algum tipo de construção, dentro de uma caverna provavelmente, sua cama de pedra fora cuidadosamente \n" +
                        "esculpida. Ao seu lado esquerdo, uma cama similar está vazia, ao direito, outra cama está ocupada com algum ser vivo deformado que começa a emitir sons altos e pertubadores. Próximo \n" +
                        "a sua cama, há um tacape que você pega. O que será feito?",
                player, tacape, 0
        );

        return new Book("...", inicial, player);
    }

    public static Book testBook() {
        Attributes attr = new AttributeBuilder()
                .setAgility(2)
                .setStrength(2)
                .setResistance(2)
                .setArmor(2)
                .setFirepower(2)
                .createAttributes();

        Player player = new Player(attr);
        Item branch =
                new Item(
                        "Ironwood Branch",
                        new AttributeBuilder()
                                .setAgility(1)
                                .setStrength(1)
                                .setResistance(1)
                                .setArmor(1)
                                .setFirepower(1)
                                .createAttributes(),
                        10,
                        ItemType.AMULET
                );

        player.addItem(branch);
        player.equipItem(branch);

        Event eventoFinal = new BlankEvent(new ArrayList<>(), "IS DEAD");

        ArrayList<Choice> start = new ArrayList<>();

        Attributes monstroAttr = new AttributeBuilder()
                .setAgility(2)
                .setStrength(1)
                .setResistance(3)
                .setArmor(2)
                .setFirepower(0)
                .createAttributes();

        AICharacter monstro = new AICharacter(monstroAttr) {
            AutoAttack ataque = new AutoAttack();
            @Override
            public Usable chooseUsable(Character enemy) {
                return ataque;
            }
        };
        BattleEvent battle = new BattleEvent(eventoFinal, monstro, player);
        Choice help = new BlankChoice("correr", eventoFinal);
        Choice fite = new BlankChoice("bater", battle);
        start.add(help);
        start.add(fite);

        Event inicial = new BlankEvent(start, "Você encontrou um bodybuilder!");

        return new Book("aaa", inicial, player);
    }
}
