package com.example;

import java.util.EnumMap;
import java.util.Map;

public enum Move {
    // Basic Face Turns
    U("U", Category.BASIC), U_("U'", Category.BASIC), U2("U2", Category.BASIC),
    D("D", Category.BASIC), D_("D'", Category.BASIC), D2("D2", Category.BASIC),
    L("L", Category.BASIC), L_("L'", Category.BASIC), L2("L2", Category.BASIC),
    R("R", Category.BASIC), R_("R'", Category.BASIC), R2("R2", Category.BASIC),
    F("F", Category.BASIC), F_("F'", Category.BASIC), F2("F2", Category.BASIC),
    B("B", Category.BASIC), B_("B'", Category.BASIC), B2("B2", Category.BASIC),

    // Wide Moves (Two layers at once)
    Uw("uw", Category.WIDE), Uw_("uw'", Category.WIDE), Uw2("uw2", Category.WIDE),
    Dw("dw", Category.WIDE), Dw_("dw'", Category.WIDE), Dw2("dw2", Category.WIDE),
    Lw("lw", Category.WIDE), Lw_("lw'", Category.WIDE), Lw2("lw2", Category.WIDE),
    Rw("rw", Category.WIDE), Rw_("rw'", Category.WIDE), Rw2("rw2", Category.WIDE),
    Fw("fw", Category.WIDE), Fw_("fw'", Category.WIDE), Fw2("fw2", Category.WIDE),
    Bw("bw", Category.WIDE), Bw_("bw'", Category.WIDE), Bw2("bw2", Category.WIDE),

    // Slice Moves (Middle layer only)
    M("M", Category.SLICE), M_("M'", Category.SLICE), M2("M2", Category.SLICE), 
    E("E", Category.SLICE), E_("E'", Category.SLICE), E2("E2", Category.SLICE), 
    S("S", Category.SLICE), S_("S'", Category.SLICE), S2("S2", Category.SLICE),

    // Cube Rotations (Whole cube)
    X("x", Category.ROTATION), X_("x'", Category.ROTATION), X2("x2", Category.ROTATION), 
    Y("y", Category.ROTATION), Y_("y'", Category.ROTATION), Y2("y2", Category.ROTATION), 
    Z("z", Category.ROTATION), Z_("z'", Category.ROTATION), Z2("z2", Category.ROTATION);

    public enum Category {
        BASIC, WIDE, SLICE, ROTATION
    }

    private static final Map<Move, Move> INVERSES = new EnumMap<>(Move.class);

    static {
        // Basic Face Turns
        INVERSES.put(U, U_); INVERSES.put(U_, U); INVERSES.put(U2, U2);
        INVERSES.put(D, D_); INVERSES.put(D_, D); INVERSES.put(D2, D2);
        INVERSES.put(L, L_); INVERSES.put(L_, L); INVERSES.put(L2, L2);
        INVERSES.put(R, R_); INVERSES.put(R_, R); INVERSES.put(R2, R2);
        INVERSES.put(F, F_); INVERSES.put(F_, F); INVERSES.put(F2, F2);
        INVERSES.put(B, B_); INVERSES.put(B_, B); INVERSES.put(B2, B2);

        // Wide Moves
        INVERSES.put(Uw, Uw_); INVERSES.put(Uw_, Uw); INVERSES.put(Uw2, Uw2);
        INVERSES.put(Dw, Dw_); INVERSES.put(Dw_, Dw); INVERSES.put(Dw2, Dw2);
        INVERSES.put(Lw, Lw_); INVERSES.put(Lw_, Lw); INVERSES.put(Lw2, Lw2);
        INVERSES.put(Rw, Rw_); INVERSES.put(Rw_, Rw); INVERSES.put(Rw2, Rw2);
        INVERSES.put(Fw, Fw_); INVERSES.put(Fw_, Fw); INVERSES.put(Fw2, Fw2);
        INVERSES.put(Bw, Bw_); INVERSES.put(Bw_, Bw); INVERSES.put(Bw2, Bw2);

        // Slice Moves
        INVERSES.put(M, M_); INVERSES.put(M_, M); INVERSES.put(M2, M2);
        INVERSES.put(E, E_); INVERSES.put(E_, E); INVERSES.put(E2, E2);
        INVERSES.put(S, S_); INVERSES.put(S_, S); INVERSES.put(S2, S2);

        // Cube Rotations
        INVERSES.put(X, X_); INVERSES.put(X_, X); INVERSES.put(X2, X2);
        INVERSES.put(Y, Y_); INVERSES.put(Y_, Y); INVERSES.put(Y2, Y2);
        INVERSES.put(Z, Z_); INVERSES.put(Z_, Z); INVERSES.put(Z2, Z2);
    }

    private final String value;
    private final Category category;

    Move(String value, Category category) {
        this.value = value;
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isBasic() {
        return this.category == Category.BASIC;
    }

    public boolean isWide() {
        return this.category == Category.WIDE;
    }

    public boolean isSlice() {
        return this.category == Category.SLICE;
    }

    public boolean isRotation() {
        return this.category == Category.ROTATION;
    }

    public Move getInverse() {
        return INVERSES.get(this);
    }
}