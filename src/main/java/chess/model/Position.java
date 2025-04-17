package chess.model;

import lombok.Value;

@Value
public class Position {
    int x;
    int y;

    public boolean isValid() {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public String toAlgebraic() {
        return "" + (char) ('a' + x) + (char) ('1' + y);
    }
}
