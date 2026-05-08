package com.example;

public class Cube {
    private int[] faces;

    public Cube() {
        this.faces = new int[6];
        for (Color color : Color.values()) {
            for (int j = 0; j < 9; j++) {
                faces[color.ordinal()] |= (color.ordinal() << (3 * j));
            }
        }
    }

    public Color ordinalToColor(int ordinal) {
        switch(ordinal) {
            case 0: return Color.WHITE;
            case 1: return Color.BLUE;
            case 2: return Color.RED;
            case 3: return Color.GREEN;
            case 4: return Color.ORANGE;
            case 5: return Color.YELLOW;
            default:
                String message = Integer.toString(ordinal) + " is not a valid ordinal for a color";
                throw new Error(message);
        }
    }

    public Color getColor(int face, int index) {
        int ordinal = (face >> (3 * index) & 0b111);
        Color color = ordinalToColor(ordinal);
        return color;
    }

    public Color[][] getFaceColors(int face) {
        Color[][] faceChars = new Color[3][3];
        int curFace = face;
        for (int i = 2; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                faceChars[i][j] = ordinalToColor(curFace & 0b111);
                curFace = curFace >> 3;
            }
        }
        return faceChars;
    }

    @Override
    public String toString() {

        StringBuilder cubeStr = new StringBuilder();
        Color[][] topFaceColors = getFaceColors(faces[5]);
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Color color = topFaceColors[row][col];
                cubeStr
                    .append(color.getAnsiString())
                    .append(color.getFirstLetter())
                    .append(' ');
            }
            cubeStr.append("\n");
        }

        Color[][][] sideFaceColors = new Color[4][][];

        for (int faceNum = 1; faceNum < 5; faceNum++) {
            sideFaceColors[faceNum - 1] = getFaceColors(faces[faceNum]);
        }

        for (int row = 0; row < 3; row++) {
            for (int faceNum = 0; faceNum < 4; faceNum++) {
                for (int col = 0; col < 3; col++) {
                    Color color = sideFaceColors[faceNum][row][col];
                    cubeStr
                        .append(color.getAnsiString())
                        .append(color.getFirstLetter())
                        .append(' ');
                }
            }
            cubeStr.append("\n");
        }

        Color[][] bottomFaceColors = getFaceColors(faces[0]);
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Color color = bottomFaceColors[row][col];
                cubeStr
                    .append(color.getAnsiString())
                    .append(color.getFirstLetter())
                    .append(' ');
            }
            cubeStr.append("\n");
        }

        cubeStr.append(Color.TextColor.RESET.getAnsiString());

        return cubeStr.toString();
    }
}

