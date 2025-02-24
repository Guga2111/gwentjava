package rounds;

import boardandplayer.Board;
import boardandplayer.Player;
import cards.Card;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Locale.filter;

public class Round {

    private final Scanner scanner = new Scanner(System.in);
    private int roundNumber = 1;

    public Round() {

    }

    public int getRoundNumber() {
        return roundNumber;
    }
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    private void eraseBoards(Player player1, Player player2) {
        player1.getBoard().eraseBoard();
        player2.getBoard().eraseBoard();
    }

    private void FoltestKing(Player player) {

        ArrayList<Card> deck = player.getDeck();
        ArrayList<Card> climates = player.getBoard().getClimate();

        for(Card card : deck) {
            if(card.getAbilities().contains("Fog")) {
                climates.add(card);
                deck.remove(card);
            }
        }
    }

    private void emhyrTheWhiteFlame() {

    }
    private void verifyHero(Player player) {

        ArrayList<Card> infantry = player.getBoard().getInfantry();
        ArrayList<Card> artillary = player.getBoard().getArtillary();
        ArrayList<Card> siege = player.getBoard().getSiege();

        for(Card card : infantry) {
            if(card.getAbilities().contains("Hero")) card.resetPoints();
        }
        for(Card card : artillary) {
            if(card.getAbilities().contains("Hero")) card.resetPoints();
        }
        for(Card card : siege) {
            if(card.getAbilities().contains("Hero")) card.resetPoints();
        }
    }

    private void commanderHornLogic(Player player, Card chosenCard) {

        System.out.println("Você deseja jogar a corneta aonde");
        System.out.println("1. - Infantaria");
        System.out.println("2. - Artilharia");
        System.out.println("3. - Cerco");

        int index = Integer.parseInt(scanner.nextLine());

        switch (index) {
            case 1:
                player.getBoard().setDoubleInfantry(true);
                for(Card card : player.getBoard().getInfantry()) {
                    card.setPoints(card.getPoints() * 2);
                }
                break;
            case 2:
                player.getBoard().setDoubleArtillary(true);
                for(Card card : player.getBoard().getArtillary()) {
                    card.setPoints(card.getPoints() * 2);
                }
                break;
            case 3:
                player.getBoard().setDoubleSiege(true);
                for(Card card : player.getBoard().getSiege()) {
                    card.setPoints(card.getPoints() * 2);
                }
                break;
        }
    }

    private void climateLogic(Player player, Card chosenCard) {

        String climate = chosenCard.getAbilities().getFirst();
        System.out.println(climate + "CODY GAKPO");
        ArrayList<Card> climates = player.getBoard().getClimate();

        ArrayList<Card> infantry = player.getBoard().getInfantry();
        ArrayList<Card> artillary = player.getBoard().getArtillary();
        ArrayList<Card> siege = player.getBoard().getSiege();

        switch(climate) {
            case "Snow":
                if(infantry.isEmpty()) break;

                for(int i = 0; i < infantry.size(); i++) {
                    Card card = infantry.get(i);
                    if(!card.getAbilities().contains("Hero")) card.setPoints(1);
                    infantry.set(i, card);
                }
                break;
            case "Fog":
                if(artillary.isEmpty()) break;

                for(int i = 0; i < artillary.size(); i++) {
                    Card card = artillary.get(i);
                    if(!card.getAbilities().contains("Hero")) card.setPoints(1);
                    artillary.set(i, card);
                }
                break;
            case "Rain":
                if(siege.isEmpty()) break;

                for(int i = 0; i < siege.size(); i++) {
                    Card card = siege.get(i);
                    if(!card.getAbilities().contains("Hero")) card.setPoints(1);
                    siege.set(i, card);
                }
                break;
            case "Sun":
                System.out.println("Enter sun logic!");
                climates.clear();
                //think how to turn back the points to the cards!
                for(Card card : infantry) {
                    card.resetPoints();
                }

                for(Card card : infantry) {
                    if(card.getAbilities().contains("Morale")) {
                        moraleLogic(player, card);
                    }
                    if(card.getAbilities().contains("Tight Bond")){
                        tightBondLogic(player, card);
                    }
                }

                for (Card card : artillary) {
                    card.resetPoints();
                }
                for(Card card : artillary) {
                    if(card.getAbilities().contains("Morale")) {
                        moraleLogic(player, card);
                    }
                    if(card.getAbilities().contains("Tight Bond")){
                        tightBondLogic(player, card);
                    }
                }

                for (Card card : siege) {
                    card.resetPoints();
                }
                for(Card card : siege) {
                    if(card.getAbilities().contains("Morale")) {
                        moraleLogic(player, card);
                    }
                    if(card.getAbilities().contains("Tight Bond")){
                        tightBondLogic(player, card);
                    }
                }

                break;
            default:
                System.out.println("Climate type unknown");
                break;
        }
    }

    private void decoyLogic(Player player, Card chosenCard) {

        System.out.println("Você deseja substituir alguma carta de qual campo: ");
        System.out.println("1. - Infantaria");
        System.out.println("2. - Artilharia");
        System.out.println("3. - Cerco");

        int index = Integer.parseInt(scanner.nextLine());

        switch (index) {
            case 1:
                int valInfantry = 1;
                for(Card card : player.getBoard().getInfantry()) {
                    System.out.println(valInfantry + ". " + card.getName() + " - " + card.getAbilities() + " - " + card.getPoints() + "pts.");
                    valInfantry++;
                }
                System.out.println("Qual carta você deseja jogar: ");
                int choose = Integer.parseInt(scanner.nextLine()) - 1;

                player.getHand().add(player.getBoard().getInfantry().get(choose));
                player.getBoard().getInfantry().remove(choose);

                chosenCard.setType("Infantry");
                player.getBoard().addCard(chosenCard);
                break;
            case 2:
                int valArtillary = 1;
                for(Card card : player.getBoard().getArtillary()) {
                    System.out.println(valArtillary + ". " + card.getName() + " - " + card.getAbilities() + " - " + card.getPoints() + "pts.");
                    valArtillary++;
                }
                System.out.println("Qual carta você deseja jogar: ");
                int choose2 = Integer.parseInt(scanner.nextLine()) - 1;

                player.getHand().add(player.getBoard().getArtillary().get(choose2));
                player.getBoard().getArtillary().remove(choose2);

                chosenCard.setType("Artillary");
                player.getBoard().addCard(chosenCard);
                break;
            case 3:
                int valSiege = 1;
                for(Card card : player.getBoard().getSiege()) {
                    System.out.println(valSiege + ". " + card.getName() + " - " + card.getAbilities() + " - " + card.getPoints() + "pts.");
                    valSiege++;
                }
                System.out.println("Qual carta você deseja jogar: ");
                int choose3 = Integer.parseInt(scanner.nextLine()) - 1;

                player.getHand().add(player.getBoard().getSiege().get(choose3));
                player.getBoard().getSiege().remove(choose3);

                chosenCard.setType("Siege");
                player.getBoard().addCard(chosenCard);
                break;
            default:
                System.out.println("Unknown type");
                break;
        }
    }

    private void musterLogic(Player player, Card chosenCard) {

        Board board = player.getBoard();

        for(Card card : player.getDeck()) {
            if(card.getName().equals(chosenCard.getName())) {
                board.addCard(card);
                player.getDeck().remove(card);
            }
        }
    }

    private void agileLogic(Card chosenCard) {

        String type = chosenCard.getType();

        if(type.equals("Infantry/Artillary")) {
            System.out.println("Carta do tipo versátil!!!");
            System.out.println("Escolha 1 para utiliza-la como infantaria ou 2 para usa-la como artilharia!");
            int index = Integer.parseInt(scanner.nextLine());

            switch(index) {
                case 1:
                    chosenCard.setType("Infantry");
                    break;
                case 2:
                    chosenCard.setType("Artillary");
                    break;
                default:
                    System.out.println("Index not recognized: " + index);
                    break;
            }
        }
    }

    private void tightBondLogic(Player player, Card chosenCard) {

        String type = chosenCard.getType();

        switch(type.toLowerCase()){
            case "infantry":
                int numberOfCardsI = 0;
                for(Card card : player.getBoard().getInfantry()) {
                    if(card.getName().equals(chosenCard.getName())) numberOfCardsI++;
                }
                for(Card card : player.getBoard().getInfantry()) {
                    if(card.getName().equals(chosenCard.getName())) {
                        int newPoints = (int) (card.getPoints() * Math.pow(2, numberOfCardsI));
                        card.setPoints(newPoints);
                    }
                }
                break;
            case "artillary":
                int numberOfCardsA = 0;
                for(Card card : player.getBoard().getArtillary()) {
                    if(card.getName().equals(chosenCard.getName())) numberOfCardsA++;
                }
                for(Card card : player.getBoard().getArtillary()) {
                    if(card.getName().equals(chosenCard.getName())) {
                        int newPoints = (int) (card.getPoints() * Math.pow(2, numberOfCardsA));
                        card.setPoints(newPoints);
                    }
                }
                break;
            case "siege":
                double numberOfCardsS = 0;
                for(Card card : player.getBoard().getSiege()) {
                    if(card.getName().equals(chosenCard.getName())) numberOfCardsS++;
                }
                for(Card card : player.getBoard().getSiege()) {
                    if(card.getName().equals(chosenCard.getName())) {
                        int newPoints = (int) (card.getPoints() * Math.pow(2, numberOfCardsS));
                        card.setPoints(newPoints);
                    }
                }
                break;
            default:
                System.out.println("Unknown card type: " + type);
                break;
        }
    }

    private void moraleLogic(Player player, Card chosenCard) {

        String type = chosenCard.getType();

        switch(type.toLowerCase()){
            case "infantry":
                for(Card card : player.getBoard().getInfantry()) {
                    if(!Objects.equals(card.getId(), chosenCard.getId())) card.setPoints(card.getPoints() + 1);
                }
                break;
            case "artillary":
                for(Card card : player.getBoard().getArtillary()) {
                    if(!Objects.equals(card.getId(), chosenCard.getId())) card.setPoints(card.getPoints() + 1);
                }
                break;
            case "siege":
                for(Card card : player.getBoard().getSiege()) {
                    if(!Objects.equals(card.getId(), chosenCard.getId())) card.setPoints(card.getPoints() + 1);
                }
                break;
            default:
                System.out.println("Unknown card type: " + type);
                break;
        }
    }

    private void scorchLogic(Player adversary, Card chosenCard) {

        String type = chosenCard.getType();

        switch(type.toLowerCase()) {
            case "infantry":
                Card powerfulCardInfantry = adversary.getBoard().getInfantry().getFirst();

                for(Card card : adversary.getBoard().getInfantry()) {
                    if(powerfulCardInfantry.getPoints() < card.getPoints() && !card.getAbilities().contains("Hero")) {
                        powerfulCardInfantry = card;
                    }
                }
                adversary.getBoard().getInfantry().remove(powerfulCardInfantry);
                adversary.getBoard().setInfantry_points(adversary.getBoard().getInfantry_points() - powerfulCardInfantry.getPoints());
                break;
            case "artillary":
                Card powerfulCardArtillary = adversary.getBoard().getArtillary().getFirst();

                for(Card card : adversary.getBoard().getArtillary()) {
                    if(powerfulCardArtillary.getPoints() < card.getPoints() && !card.getAbilities().contains("Hero")) {
                        powerfulCardArtillary = card;
                    }
                }
                adversary.getBoard().getArtillary().remove(powerfulCardArtillary);
                adversary.getBoard().setArtillary_points(adversary.getBoard().getArtillary_points() - powerfulCardArtillary.getPoints());
                break;
            case "siege":
                Card powerfulCardSiege = adversary.getBoard().getSiege().getFirst();

                for(Card card : adversary.getBoard().getSiege()) {
                    if(powerfulCardSiege.getPoints() < card.getPoints() && !card.getAbilities().contains("Hero")) {
                        powerfulCardSiege = card;
                    }
                }
                adversary.getBoard().getSiege().remove(powerfulCardSiege);
                adversary.getBoard().setSiege_points(adversary.getBoard().getSiege_points() - powerfulCardSiege.getPoints());
                break;
            default:
                System.out.println("Unknown card type: " + type);
                break;
        }
    }

    private void healLogic(Player player) {
        ArrayList<Card> discard = player.getBoard().getDiscard();

        System.out.println("Escolha um carta da pilha de descarte!");
        int index = 1;
        for (Card card : discard) {
            System.out.println(index + ". " + card.getName());
            index++;
        }

        System.out.println("Qual carta você deseja jogar: ");
        try{
            int choose = Integer.parseInt(scanner.nextLine()) - 1;

            if (choose >= 0 && choose < discard.size()) {
                Card chosenCard = discard.get(choose);
                player.getBoard().addCard(chosenCard);
                discard.remove(choose);
            } else {
                System.out.println("Escolha inválida. Tente novamente");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Tente novamente");
        }
    }

    private void spyLogic(Player player) {

        Random random1 = new Random();
        Random random2 = new Random();

        ArrayList<Card> deck = player.getDeck();

        int card1Number = random1.nextInt(deck.size());
        int card2Number = random2.nextInt(deck.size());

        Card card1 = deck.get(card1Number);
        Card card2 = deck.get(card2Number);

        deck.remove(card1Number);
        deck.remove(card2Number - 1);

        player.getHand().add(card1);
        player.getDeck().add(card2);
    }

    private void verifyPoints(Player player1, Player player2) {

        Board board1 = player1.getBoard();
        Board board2 = player2.getBoard();

        if(board1.getPoints() > board2.getPoints()){
            player2.setHp(player2.getHp() - 1);
            System.out.println("Player1 ganhou esse round.");
        }
        else if(board2.getPoints() > board1.getPoints()){
            player1.setHp(player1.getHp() - 1);
            System.out.println("Player2 ganhou esse round.");
        }
        else{
            player1.setHp(player1.getHp() - 1);
            player2.setHp(player2.getHp() - 1);
            System.out.println("Ambos players empataram!");
        }

        player1.setContinueMove(false);
        player2.setContinueMove(false);
        roundNumber++;
        System.out.println("Vamos para o round: " + roundNumber);
    }

    private void playLogic(Player player, Player adversary) {

        ArrayList<Card> playerHand = player.getHand();
        Board board = player.getBoard();
        Board board2 = adversary.getBoard();
        board.ensurePoints(player);
        board.ensurePoints(adversary);

        System.out.println("Voce deseja passar sua vez, responda com (S) ou (N) ou (LEADER): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        if(Arrays.asList(Constants.ANSWERS).contains(choice.toLowerCase())) {
            System.out.println("Voce desejou passar sua rodada!");
            player.setContinueMove(false);
        }
        else{
            if(!Arrays.asList(Constants.LEADER).contains(choice.toLowerCase())) {
                player.setContinueMove(true);

                int index = 1;
                for (Card card : playerHand) {
                    System.out.println(index + ". " + card.getName() + " - " + card.getAbilities() + " - " + card.getPoints() + "pts.");
                    index++;
                }

                System.out.println("Qual carta você deseja jogar: ");
                try{
                    int choose = Integer.parseInt(scanner.nextLine()) - 1;

                    if (choose >= 0 && choose < playerHand.size()) {
                        //falta algumas verificações quando for usar a carta 'sun' pois precisa verificar boost morales e tight bonds
                        verifyHero(player);

                        Card chosenCard = playerHand.get(choose);

                        boolean existSnow1 = board.getClimate().stream().anyMatch(card -> card.getName().equals("Snow"));
                        boolean existSnow2 = board2.getClimate().stream().anyMatch(card -> card.getName().equals("Snow"));
                        if((existSnow1 || existSnow2) && chosenCard.getType().equals("Infantry")) chosenCard.setPoints(1);


                        boolean existRain1 = board.getClimate().stream().anyMatch(card -> card.getName().equals("Rain"));
                        boolean existRain2 = board2.getClimate().stream().anyMatch(card -> card.getName().equals("Rain"));
                        if((existRain1 || existRain2) && chosenCard.getType().equals("Siege")) chosenCard.setPoints(1);

                        boolean existFog1 = board.getClimate().stream().anyMatch(card -> card.getName().equals("Fog"));
                        boolean existFog2 = board2.getClimate().stream().anyMatch(card -> card.getName().equals("Fog"));
                        String stringFog = String.valueOf(existFog1);
                        System.out.println(board.getClimate().isEmpty() + "GETCLIME EMPTY°");
                        System.out.println(stringFog + "EXIST FOG BOOLEAN.");
                        if((existFog1 || existFog2) && chosenCard.getType().equals("Siege")) chosenCard.setPoints(1);

                        if(chosenCard.getAbilities().contains("Heal")) healLogic(player);
                        if(chosenCard.getAbilities().contains("Spy")) spyLogic(player);
                        if(chosenCard.getAbilities().contains("Scorch")) scorchLogic(adversary, chosenCard);
                        if(chosenCard.getAbilities().contains("Morale")) moraleLogic(player, chosenCard);
                        if(chosenCard.getAbilities().contains("Tight Bond")) tightBondLogic(player, chosenCard);
                        if(chosenCard.getAbilities().contains("Agile")) agileLogic(chosenCard);
                        if(chosenCard.getAbilities().contains("Muster")) musterLogic(player, chosenCard);
                        if(chosenCard.getAbilities().contains("Decoy")) decoyLogic(player, chosenCard);
                        if (Stream.of("Snow", "Rain", "Fog", "Sun")
                                .anyMatch(chosenCard.getAbilities()::contains)) {
                            climateLogic(player, chosenCard);
                            System.out.println("SALAH");
                        }

                        if(board.isDoubleInfantry() && chosenCard.getType().equals("Infantry")) chosenCard.setPoints(chosenCard.getPoints() * 2);
                        if(board.isDoubleArtillary() && chosenCard.getType().equals("Artillary")) chosenCard.setPoints(chosenCard.getPoints() * 2);
                        if(board.isDoubleSiege() && chosenCard.getType().equals("Siege")) chosenCard.setPoints(chosenCard.getPoints() * 2);

                        if(chosenCard.getAbilities().contains("CommanderHorn")) commanderHornLogic(player, chosenCard);

                        System.out.println(chosenCard.getPoints());
                        board.addCard(chosenCard);
                        System.out.println(board.getClimate().isEmpty() + "GETCLIJME EMPTY2");
                        playerHand.remove(choose);

                        verifyHero(player);
                    } else {
                        System.out.println("Escolha inválida. Tente novamente");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Tente novamente");
                }
            } else {
                //leader logic!

                String leadersName = board.getLeader().getName();

                if(leadersName.startsWith("Emhyr")) {

                }
                if(leadersName.startsWith("Foltest")) {

                }
                if(leadersName.startsWith("Francesca")) {

                }
                if(leadersName.startsWith("Eredin")) {

                }
            }

        }
    }

    private void roundLogic(Player player1, Player player2) {

        Random random = new Random();
        int head_tails = random.nextInt(2);

        Player firstPlayer = (head_tails == 0) ? player1 : player2;
        Player secondPlayer = (head_tails == 0) ? player2 : player1;

        System.out.print("O jogador inicial será: " + (head_tails == 0 ? "Player 1" : "Player 2"));
        System.out.println(" -> " + firstPlayer.getName());

        while ((player1.getHp() > 0 && player2.getHp() > 0) && (player1.isContinueMove() || player2.isContinueMove())) {

            if (player1.getHp() <= 0 || player2.getHp() <= 0) {
                System.out.println("Ambos jogadores sem vida!");
                break;
            }

            if (!player1.isContinueMove() && !player2.isContinueMove()) {
                System.out.println("Ambos jogadores passaram!");
                break;
            }

            if(firstPlayer.isContinueMove()) {
                firstPlayer.getBoard().showBoard(player1, player2);
                playLogic(firstPlayer, secondPlayer);

                String condition = Boolean.toString(firstPlayer.isContinueMove());
                System.out.println("O jogador1 é: " + condition);
            }

            if(secondPlayer.isContinueMove()) {
                secondPlayer.getBoard().showBoard(player1, player2);
                playLogic(secondPlayer, firstPlayer);

                String condition = Boolean.toString(secondPlayer.isContinueMove());
                System.out.println("O jogador2 é: " + condition);
            }

        }
        verifyPoints(player1, player2);
    }

    public void gameAlgorithm(Player player1, Player player2) {

        player1.shuffle(player1.getDeck(), player1.getHand());
        player2.shuffle(player2.getDeck(), player2.getHand());

        System.out.println("Player1: ");
        for(Card card : player1.getHand()) {
            System.out.println(card.getName());
        }

        System.out.println("Player2: ");
        for(Card card : player2.getHand()) {
            System.out.println(card.getName());
        }

        while(player1.getHp() > 0 || player2.getHp() > 0 && roundNumber < 4) {

            System.out.println("Está começando o round: " + roundNumber);

            Board board1 = player1.getBoard();
            Board board2 = player2.getBoard();
            if(!(board1.isBoardEmpty() && board2.isBoardEmpty())) eraseBoards(player1,player2);

            player1.setContinueMove(true);
            player2.setContinueMove(true);

            roundLogic(player1,player2);
        }

        if (player1.getHp() <= 0 && player2.getHp() <= 0) {
            System.out.println("O jogo terminou em empate!");
        } else if (player1.getHp() > 0) {
            System.out.println("Player1 venceu o jogo!");
        } else {
            System.out.println("Player2 venceu o jogo!");
        }
    }
}
