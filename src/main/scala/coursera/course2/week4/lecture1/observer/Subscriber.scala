package coursera.course2.week4.lecture1.observer

trait Subscriber extends Subscriber {
  def handler(pub: Publisher)


}
