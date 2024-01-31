const FormatDate = (date) => {
    const formattedDate = new Date(date.date);
    return formattedDate.toLocaleDateString();
}
export default FormatDate