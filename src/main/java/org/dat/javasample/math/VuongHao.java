package org.dat.javasample.math;

import java.util.List;

public class VuongHao {
    private static class MenhDe{
        public char kyHieu;
        public List<MenhDe> dsMenhDeCon;
        public List<Character> dsToanTu;
        public boolean phuDinh=false;
    }
    private static class BieuThuc{
        public MenhDe left;
        public MenhDe right;
        public int daXet;
    }
}
