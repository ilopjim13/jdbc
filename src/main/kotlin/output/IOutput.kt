package output

interface IOutput {
    fun showMessage(message:String, lineBreak:Boolean = true)
}