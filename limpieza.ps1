# Ruta al directorio del proyecto
$projectDir = Get-Location

# Directorios de caché a eliminar
$cacheDirs = @("bin", "target", ".gradle")

# Eliminar los directorios de caché
foreach ($dir in $cacheDirs) {
    $dirPath = Join-Path $projectDir $dir
    if (Test-Path $dirPath) {
        Remove-Item $dirPath -Recurse -Force
        Write-Host "Directorio de caché eliminado: $dirPath"
    } else {
        Write-Host "Directorio de caché no encontrado: $dirPath"
    }
}

# Limpiar el caché de lenguaje Java de VS Code
$vscodeJavaCache = Join-Path $env:USERPROFILE "\.vscode\extensions"
Get-ChildItem $vscodeJavaCache | Where-Object {$_.Name -like "vscjava.vscode-java-*" } | ForEach-Object {
    $languageServerCache = Join-Path $_.FullName "server\workspace"
    if (Test-Path $languageServerCache){
        Remove-Item $languageServerCache -Recurse -Force
        Write-Host "Caché de lenguaje Java de VS Code eliminado: $languageServerCache"
    }
}

Write-Host "Limpieza de caché completada."