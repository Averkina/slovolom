package Filed;

public class Field {
    private static final int MAX_CELL_VALUE=3;
    private static final int MIN_CELL_VALUE=1;
    private static final int DEFAULT_FIELD_SIZE=3;
    private static final char DEFAULT_CELL_VALUE=' ';
    private static final char FIRST_PLAYER_MARK = 'x';
    private static final char SECOND_PLAYER_MARK = 'o';

    public int fieldSize;

    public char[][] items;

    public Field(){
        this(DEFAULT_FIELD_SIZE);
    }

    public Field(int size){
        fieldSize=size+1;
        items = new char[fieldSize][fieldSize];
    }

    public void fieldCreate(){
        for (int i = 0; i < fieldSize; i++){
            lineCreate (i);
        }
    }

    private void lineCreate(int lineNumber){
        for (int i=0; i < fieldSize; i++){
            items[i][lineNumber]=DEFAULT_CELL_VALUE;
        }
    }

    public void showField(){
        for (int i = 0; i < fieldSize; i++){
            showLine(i);
            System.out.println();
        }
    }

    private void showLine(int lineNumber){
        for (int i = 0; i < fieldSize; i++){
            if ((lineNumber == 0) && (i == 0)){
                System.out.print("   ");
            }else if (lineNumber == 0){
                System.out.print("[" + i + "]");
            }else if (i == 0){
                System.out.print("[" + lineNumber + "]");
            }else{
                System.out.print("[" + items[i][lineNumber] + "]");
            }
        }
    }

    public boolean cellWasReceived(int cell, int line, char playerNumber){

        if (playerNumber == FIRST_PLAYER_MARK){
            if (!valuesCheck(cell, line)) {
                System.out.println("Wrong cell or line value, remove please!");
                return false;
            }else{
                items[cell][line] = FIRST_PLAYER_MARK;
                showField();
                return true;
            }
        }else{
            if (!valuesCheck(cell, line)) {
                System.out.println("Wrong cell or line value, remove please!");
                return false;
            }else{
                items[cell][line] = SECOND_PLAYER_MARK;
                showField();
                return true;
            }
        }
    }

    private boolean valuesCheck(int cellValue, int lineValue){
        return (cellValueCheck(cellValue) && lineValueCheck(lineValue) && isFreeCell(cellValue, lineValue));
    }

    private boolean isFreeCell(int cell, int line){
        return (items[cell][line] == ' ');
    }

    private boolean cellValueCheck(int cellValue){
        return (cellValue <= MAX_CELL_VALUE && cellValue >= MIN_CELL_VALUE);
    }

    private boolean lineValueCheck(int lineValue){
        return (lineValue <= MAX_CELL_VALUE && lineValue >= MIN_CELL_VALUE);
    }
}