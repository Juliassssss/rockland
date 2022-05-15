package com.example.diplom.ui.main.data



class LogUseCase(private val logging: ILogging) : ILoggingDelegate {

    companion object {
        const val FOLDER = "Logs"
        const val COUNT_DAY_SAVE = 14
        const val FORMAT_FILE = "txt"
    }

    init {
        logging.setLogFile(FOLDER, getCurName())
    }

    private fun getCurName(): String {
        return "${logging.getCurDateTime(ILogging.Format.FORMAT_DATE_FILE)}.${FORMAT_FILE}"
    }

    fun clear() {
        val files = logging.getAllFiles(FOLDER)
        if (!files.any()) {
            return
        }
        var countDaySave = COUNT_DAY_SAVE
        val maxFile = logging.getAllFiles(FOLDER).maxOrNull()
        if (maxFile != null && maxFile == getCurName()) {
            countDaySave += 1
        }
        for (file in logging.getAllFiles(FOLDER).sortedDescending().drop(countDaySave)) {
            logging.setLogFile(FOLDER, file)
            logging.delete()
        }
    }

    suspend fun getSendData() : ISendData {
        return logging.getSendData()
    }

    override fun log(level: LevelLogging, message: String) {
        logging.setLogFile(FOLDER, getCurName())
        logging.write("${logging.getCurDateTime(ILogging.Format.FORMAT_DATE_IN_LOG)} ${level.name}: ${message}\n")
    }
}