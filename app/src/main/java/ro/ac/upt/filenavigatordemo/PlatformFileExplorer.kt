package ro.ac.upt.filenavigatordemo

import java.io.File


class PlatformFileExplorer {

    fun listFiles(fileEntry: FileEntry): List<FileEntry> {
        //TODO("Return the files contained by the current directory (both plain files and directories)")
        val directory = File(fileEntry.path)
        val files = directory.listFiles()
        val fileEntryList = mutableListOf<FileEntry>()
        return if(files != null){
            for (i in files) {
                fileEntryList.add(FileEntry(i.path,i.isDirectory))
            }
            fileEntryList
        } else
            emptyList()
    }

    fun hasParent(fileEntry: FileEntry): Boolean {
        //TODO("Check if current file entry has a parent directory")
        val file = File(fileEntry.path)
        return file.parentFile != null
    }

    fun getParent(fileEntry: FileEntry): FileEntry {
        //TODO("Return the parent of current file entry")
        val parent = File(fileEntry.path).parentFile
        return FileEntry(parent.path,parent.isDirectory)
    }

}