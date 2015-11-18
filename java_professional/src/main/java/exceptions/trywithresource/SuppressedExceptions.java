package exceptions.trywithresource;


class RiverRaft implements AutoCloseable {
    public RiverRaft() throws Exception {
        System.out.println("Start raft");
    }

    public void crossRapid() throws Exception {
        System.out.println("Cross rapid");
        throw new Exception("Cross Rapid exception");
    }

    public void close() throws Exception {
        System.out.println("Reach river bank");
        throw new Exception("Close exception"); // suppressed
    }
}


public class SuppressedExceptions {
    public static void main(String[] args) throws Exception {
        try (RiverRaft raft = new RiverRaft();) {
            raft.crossRapid();
        } catch (Exception e) {
            System.out.println("Exception caught:" + e);
            Throwable[] exs = e.getSuppressed();
            if (exs.length>0)
                System.out.println("Suppresed exception " + exs[0]);
        }
    }
}
