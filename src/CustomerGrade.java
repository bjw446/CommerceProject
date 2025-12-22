public enum CustomerGrade {
    BRONZE(1),
    SILVER(2),
    GOLD(3),
    PLATINUM(4);

    private final int gradeInt;

    CustomerGrade(int gradeInt) {
        this.gradeInt = gradeInt;
    }

    public double getGradeInt() {
        return gradeInt;
    }

    public static CustomerGrade fromInt(int gradeInt) {
        for(CustomerGrade a : values()) {
            if(a.gradeInt == gradeInt) {
                return a;
            }
        }
        throw new IllegalArgumentException("잘못된 고객등급 입니다.");
    }

}
