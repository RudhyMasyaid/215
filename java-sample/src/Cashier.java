class Cashier {
    private ArrayList<Item> items; // Menyimpan daftar barang dalam ArrayList.

    public Cashier() {
        // Konstruktor menginisialisasi ArrayList untuk daftar barang.
        items = new ArrayList<>();
    }

    public void addItem(int price, String code, String name, int qty) {
        // Menambahkan barang ke daftar dengan detail harga, kode, nama, dan jumlah.
        items.add(new Item(code, name, price, qty));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        // Menghapus barang dari daftar berdasarkan kode barang.
        items.removeIf(item -> item.getCode().equals(code));
        System.out.println("Barang dihapus.");
    }

    public void displayTotal() {
        // Menampilkan header daftar belanja
        System.out.println("------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s\n", "Kode", "Nama Barang", "Harga", "Jumlah", "SubTotal");
        System.out.println("------------------------------------------------");

        int total = 0;
        for (Item item : items) {
            int subTotal = item.getSubTotal(); // Menghitung subtotal barang.
            total += subTotal; // Menambahkan subtotal ke total keseluruhan.
            
            // Menggunakan printf untuk merapikan tampilan daftar barang
            System.out.printf("%-10s %-20s %-10d %-10d %-10d\n",
                    item.getCode(), item.getName(), item.getPrice(), item.getQty(), subTotal);
        }

        // Menampilkan total belanja di akhir
        System.out.println("------------------------------------------------");
        System.out.printf("%-40s %-10d\n", "Total Belanja:", total);
    }

    public void processPayment(int payment) {
        // Menghitung total belanja.
        int total = items.stream().mapToInt(Item::getSubTotal).sum();
        int change = payment - total; // Menghitung kembalian.

        // Menampilkan total belanja dan jumlah yang dibayarkan.
        System.out.println("Total bayar: " + total);
        System.out.println("Dibayar: " + payment);

        if (payment < total) {
            // Jika pembayaran kurang dari total, hitung kekurangan bayar.
            int shortage = total - payment;
            System.out.println("Kekurangan bayar: " + shortage);
        } else {
            // Jika pembayaran cukup atau lebih, tampilkan kembalian.
            System.out.println("Kembalian: " + change);
        }
    }

    public boolean isEmpty() {
        // Mengecek apakah daftar barang kosong.
        return items.isEmpty();
    }
}
