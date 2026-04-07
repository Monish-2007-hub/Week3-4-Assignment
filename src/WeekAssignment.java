import java.util.*;

public class WeekAssignment {

    // ===================== P1 =====================
    static class Transaction {
        String id;
        double fee;
        String timestamp;

        Transaction(String id, double fee, String timestamp) {
            this.id = id;
            this.fee = fee;
            this.timestamp = timestamp;
        }

        public String toString() {
            return id + ":" + fee + "@" + timestamp;
        }
    }

    static void bubbleSortTransactions(List<Transaction> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        System.out.println("P1 Bubble: " + list);
    }

    // ===================== P2 =====================
    static class Client {
        String name;
        int riskScore;
        double balance;

        Client(String name, int riskScore, double balance) {
            this.name = name;
            this.riskScore = riskScore;
            this.balance = balance;
        }

        public String toString() {
            return name + ":" + riskScore;
        }
    }

    static void bubbleSortClients(Client[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("P2 Bubble: " + Arrays.toString(arr));
    }

    // ===================== P3 =====================
    static class Trade {
        String id;
        int volume;

        Trade(String id, int volume) {
            this.id = id;
            this.volume = volume;
        }

        public String toString() {
            return id + ":" + volume;
        }
    }

    static void mergeSortTrades(Trade[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSortTrades(arr, l, m);
            mergeSortTrades(arr, m + 1, r);
            mergeTrades(arr, l, m, r);
        }
    }

    static void mergeTrades(Trade[] arr, int l, int m, int r) {
        Trade[] temp = new Trade[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (arr[i].volume <= arr[j].volume) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (i = l, k = 0; i <= r; i++, k++) arr[i] = temp[k];
    }

    // ===================== P4 =====================
    static class Asset {
        String name;
        double returnRate;

        Asset(String name, double returnRate) {
            this.name = name;
            this.returnRate = returnRate;
        }

        public String toString() {
            return name + ":" + returnRate;
        }
    }

    static void quickSortAssets(Asset[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionAssets(arr, low, high);
            quickSortAssets(arr, low, pi - 1);
            quickSortAssets(arr, pi + 1, high);
        }
    }

    static int partitionAssets(Asset[] arr, int low, int high) {
        double pivot = arr[high].returnRate;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].returnRate > pivot) {
                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Asset temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // ===================== P5 =====================
    static boolean linearSearch(String[] arr, String target) {
        for (String s : arr) {
            if (s.equals(target)) return true;
        }
        return false;
    }

    // ===================== P6 =====================
    static void binaryFloorCeiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = ceil = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Floor: " + floor + ", Ceiling: " + ceil);
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {

        // P1
        List<Transaction> tx = new ArrayList<>();
        tx.add(new Transaction("id1", 10.5, "10:00"));
        tx.add(new Transaction("id2", 25.0, "09:30"));
        tx.add(new Transaction("id3", 5.0, "10:15"));
        bubbleSortTransactions(tx);

        // P2
        Client[] clients = {
                new Client("A", 20, 1000),
                new Client("B", 50, 2000),
                new Client("C", 80, 3000)
        };
        bubbleSortClients(clients);

        // P3
        Trade[] trades = {
                new Trade("t1", 100),
                new Trade("t2", 300),
                new Trade("t3", 200)
        };
        mergeSortTrades(trades, 0, trades.length - 1);
        System.out.println("P3 Sorted: " + Arrays.toString(trades));

        // P4
        Asset[] assets = {
                new Asset("AAPL", 12),
                new Asset("TSLA", 8),
                new Asset("GOOG", 15)
        };
        quickSortAssets(assets, 0, assets.length - 1);
        System.out.println("P4 Sorted: " + Arrays.toString(assets));

        // P5
        String[] logs = {"accA", "accB", "accC"};
        System.out.println("P5 Search: " + linearSearch(logs, "accB"));

        // P6
        int[] risks = {10, 25, 50, 100};
        binaryFloorCeiling(risks, 30);
    }
}