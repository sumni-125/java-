package day14.인터페이스.scheduler;

class RoundRobin implements Scheduler{

    public void getNextCall() {
          System.out.println(  "상담전화를 순서대로 대기열에서 가져옵니다 ");
    }

   public void sendCallToAgent() {
        System.out.println(  "다음 순서 상담원에게 배분합니다");
   }
}


