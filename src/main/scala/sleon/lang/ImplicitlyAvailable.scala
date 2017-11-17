package sleon.lang

trait ImplicitlyAvailable {

  final implicit lazy val implicitlyAvailable: this.type = this

}
