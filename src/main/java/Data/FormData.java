package Data;

public enum FormData {
    VERY_INTERESTING(0),
    JUST_LOOKING(1),

    ONE_TO_FIVE(0),
    SIX_FIFTEEN(1),
    SIXTEEN_TWENTYFIVE(2),
    TWENTYSIX_FIFTY(3),
    FIFTY_PLUS(4),

    YES(0),
    NO(1),
    OTHER(2);
    public int value;

    FormData(int value){
        this.value = value;
    }
}

